package com.projeto.sistema_gerenciamento_faculdade.dto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
   
import com.projeto.sistema_gerenciamento_faculdade.entity.Professor;

public record ProfessorResponseDto(UUID id, String nome, String email, List<String> nomeDisciplinas) {

    public ProfessorResponseDto(Professor professor)
    {
        this(professor.getId(), professor.getNome(), professor.getEmail(), professor.getDisciplinas() != null
         ? professor.getDisciplinas().stream().map(disciplina -> disciplina.getNome()).collect(Collectors.toList()) : List.of());
    }

}
