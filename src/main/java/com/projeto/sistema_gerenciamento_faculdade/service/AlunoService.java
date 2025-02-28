package com.projeto.sistema_gerenciamento_faculdade.service;

import org.springframework.stereotype.Service;


import com.projeto.sistema_gerenciamento_faculdade.dto.AlunoRequestDto;
import com.projeto.sistema_gerenciamento_faculdade.dto.AlunoResponseDto;
import com.projeto.sistema_gerenciamento_faculdade.entity.Aluno;
import com.projeto.sistema_gerenciamento_faculdade.repository.AlunoRepository;

@Service
public class AlunoService {

    private AlunoRepository alunoRepository;

    AlunoService(AlunoRepository alunoRepository)
    {
        this.alunoRepository = alunoRepository;
    }

    public AlunoResponseDto cadastrarAluno(AlunoRequestDto alunoRequestDto)
    {

        Aluno aluno = alunoRequestDto.toEntity();
        Aluno savedAluno = alunoRepository.save(aluno);
        return new AlunoResponseDto(savedAluno);
    }
    
}
