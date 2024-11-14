package com.sistdist.diploma_generator.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lowagie.text.DocumentException;
import com.sistdist.diploma_generator.entity.Aluno;
import com.sistdist.diploma_generator.service.MinioService;
import com.sistdist.diploma_generator.service.PdfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RabbitMQConsumer {

    private PdfService pdfService;
    private MinioService minioService;
    private RabbitTemplate rabbitTemplate;
    private ObjectMapper objectMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);

    public RabbitMQConsumer(PdfService pdfService, MinioService minioService, RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.pdfService = pdfService;
        this.minioService = minioService;
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consumir(Message mensagem) throws JsonProcessingException {
        String correlationId = mensagem.getMessageProperties().getCorrelationId();
        String filaResposta = mensagem.getMessageProperties().getReplyTo();

        String alunoJson = new String(mensagem.getBody());
        Aluno aluno = objectMapper.readValue(alunoJson, Aluno.class);

        LOGGER.info("Mensagem recebida: {}", aluno);

        String nomePdf = "diploma_" + aluno.getRg() + "_hash_code_" + aluno.hashCode() + ".pdf";

        try {
            byte[] conteudoPdf = pdfService.gerarPdf(aluno, nomePdf);
            minioService.subirPdf(conteudoPdf, nomePdf);
            LOGGER.info("{} enviado para o MinIO com sucesso!", nomePdf);

            Message mensagemResposta = new Message(conteudoPdf, new MessageProperties());
            mensagemResposta.getMessageProperties().setCorrelationId(correlationId);
            mensagemResposta.getMessageProperties().setReplyTo(filaResposta);

            rabbitTemplate.send(filaResposta, mensagemResposta);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }

}
