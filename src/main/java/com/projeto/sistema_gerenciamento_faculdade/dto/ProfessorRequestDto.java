package com.projeto.sistema_gerenciamento_faculdade.dto;

import java.util.List;

import com.projeto.sistema_gerenciamento_faculdade.entity.Disciplina;
import com.projeto.sistema_gerenciamento_faculdade.entity.Professor;

public record ProfessorRequestDto(String nome, int idade, String cpf, String email, 
    List<Disciplina> disciplinas) {

        public Professor toEntity()
        {
            return new Professor(nome,idade, cpf,email, disciplinas);
        }

}
