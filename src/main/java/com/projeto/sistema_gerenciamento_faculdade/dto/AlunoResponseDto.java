package com.projeto.sistema_gerenciamento_faculdade.dto;

import java.util.UUID;

import com.projeto.sistema_gerenciamento_faculdade.entity.Aluno;

public record AlunoResponseDto( UUID id, String nome, String email) {

    public AlunoResponseDto(Aluno aluno)
    {
        this(aluno.getId(), aluno.getNome(), aluno.getEmail());
    }

}
