package com.sistdist.diploma_generator.service;

import com.lowagie.text.DocumentException;
import com.sistdist.diploma_generator.entity.Aluno;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class PdfService {

    @Cacheable("diplomas")
    public byte[] gerarPdf(Aluno aluno, String nomePdf) throws IOException, DocumentException {

        String htmlTemplate = new String(Files.readAllBytes(Paths.get("src/main/resources/templates/template-diploma.html")));

        htmlTemplate = htmlTemplate.replace("[[nome]]", aluno.getNome())
                .replace("[[nacionalidade]]", aluno.getNacionalidade())
                .replace("[[estado]]", aluno.getEstado())
                .replace("[[data_nascimento]]", aluno.getDataDeNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .replace("[[documento]]", aluno.getRg())
                .replace("[[data_conclusao]]", aluno.getDataDeConclusao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .replace("[[curso]]", aluno.getCurso())
                .replace("[[nivel_de_especializacao]]", aluno.getNivelDeEspecializacao())
                .replace("[[carga_horaria]]", aluno.getCargaHorariaEmHoras())
                .replace("[[data_emissao]]", LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .replace("[[nome_assinatura]]", "Gregório Souza Martines")
                .replace("[[cargo]]", "Vice-presidente da Universidade de Programação");


        return gerarPdfDeHtml(htmlTemplate);
    }

    private byte[] gerarPdfDeHtml(String conteudoHtml) throws IOException, DocumentException {
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(conteudoHtml);
        renderer.layout();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        renderer.createPDF(os);
        os.close();

        return os.toByteArray();
    }

}
