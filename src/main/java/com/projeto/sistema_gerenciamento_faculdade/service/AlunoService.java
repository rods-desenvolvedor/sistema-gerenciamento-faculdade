package com.projeto.sistema_gerenciamento_faculdade.service;

import org.springframework.stereotype.Service;

import com.projeto.sistema_gerenciamento_faculdade.dto.AlunoDto;
import com.projeto.sistema_gerenciamento_faculdade.entity.Aluno;
import com.projeto.sistema_gerenciamento_faculdade.repository.AlunoRepository;

@Service
public class AlunoService {

    private AlunoRepository alunoRepository;

    AlunoService(AlunoRepository alunoRepository)
    {
        this.alunoRepository = alunoRepository;
    }

    public Aluno cadastrarAluno(AlunoDto alunoDto)
    {
        Aluno aluno = new Aluno(alunoDto.nome(), alunoDto.idade(), 
        alunoDto.cpf(), alunoDto.matricula(), alunoDto.email());

        return aluno;
    }
    
}
