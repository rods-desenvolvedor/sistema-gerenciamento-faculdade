package com.projeto.sistema_gerenciamento_faculdade.dto;

import java.util.UUID;

import com.projeto.sistema_gerenciamento_faculdade.entity.Disciplina;

public record DisciplinaResponseDto(UUID id, String nome, int cargaHoraria, String nomeProfessor) {

    public DisciplinaResponseDto(Disciplina disciplina)
    {
        this(disciplina.getId(), disciplina.getNome(), disciplina.getCargaHoraria(), disciplina.getProfessor().getNome());
    }

}
