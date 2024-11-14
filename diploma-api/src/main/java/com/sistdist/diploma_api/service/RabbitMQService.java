package com.sistdist.diploma_api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sistdist.diploma_api.entity.Aluno;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RabbitMQService {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    @Value("${rabbitmq.queue.response}")
    private String responseQueue;

    private RabbitTemplate rabbitTemplate;
    private ObjectMapper objectMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQService.class);

    public RabbitMQService(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    public void enviarMensagem(Aluno aluno) throws JsonProcessingException {
        LOGGER.info("Mensagem enviada: {}", aluno);

        String alunoJson = objectMapper.writeValueAsString(aluno);
        String correlationId = UUID.randomUUID().toString();

        Message mensagem = new Message(alunoJson.getBytes(), new MessageProperties());
        mensagem.getMessageProperties().setCorrelationId(correlationId);
        mensagem.getMessageProperties().setReplyTo(responseQueue);
        rabbitTemplate.send(exchange, routingKey, mensagem);
    }

    public byte[] receberResposta() {
        return (byte[]) rabbitTemplate.receiveAndConvert(responseQueue);
    }
}
