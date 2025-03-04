package com.projeto.sistema_gerenciamento_faculdade.dto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.projeto.sistema_gerenciamento_faculdade.entity.Disciplina;

public record DisciplinaResponseDto(UUID id, String nome, int cargaHoraria, String nomeProfessor, List<String> alunos) {

    public DisciplinaResponseDto(Disciplina disciplina)
    {
        this(disciplina.getId(), disciplina.getNome(), disciplina.getCargaHoraria(), 
        disciplina.getProfessor().getNome(),
        disciplina.getAlunos().stream().map(aluno -> aluno.getNome())
        .collect(Collectors.toList()));
    }

}
