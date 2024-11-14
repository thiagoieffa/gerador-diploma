package com.sistdist.diploma_api.service;

import com.sistdist.diploma_api.entity.Aluno;
import com.sistdist.diploma_api.repository.AlunoRepository;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

}
