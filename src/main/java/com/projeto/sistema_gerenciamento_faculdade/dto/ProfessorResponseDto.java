package com.projeto.sistema_gerenciamento_faculdade.dto;

import java.util.List;
import java.util.UUID;

import com.projeto.sistema_gerenciamento_faculdade.entity.Disciplina;   
import com.projeto.sistema_gerenciamento_faculdade.entity.Professor;

public record ProfessorResponseDto(UUID id, String nome, String email, List<Disciplina> disciplinas) {

    public ProfessorResponseDto(Professor professor)
    {
        this(professor.getId(), professor.getNome(), professor.getEmail(), professor.getDisciplinas());
    }

}
