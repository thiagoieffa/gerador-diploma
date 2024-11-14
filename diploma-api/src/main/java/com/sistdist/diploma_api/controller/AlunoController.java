package com.sistdist.diploma_api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sistdist.diploma_api.entity.Aluno;
import com.sistdist.diploma_api.service.RabbitMQService;
import com.sistdist.diploma_api.service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class AlunoController {

    private RabbitMQService rabbitMQService;
    private AlunoService alunoService;

    public AlunoController(RabbitMQService rabbitMQService, AlunoService alunoService) {
        this.rabbitMQService = rabbitMQService;
        this.alunoService = alunoService;
    }

    @PostMapping("diploma")
    public ResponseEntity<byte[]> sendMessage(@RequestBody Aluno aluno) throws JsonProcessingException {
        alunoService.save(aluno);
        rabbitMQService.enviarMensagem(aluno);
        byte[] pdf = rabbitMQService.receberResposta();
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=\"diploma.pdf\"")
                .body(pdf);
    }

}
