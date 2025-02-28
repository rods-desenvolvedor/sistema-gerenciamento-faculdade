package com.projeto.sistema_gerenciamento_faculdade.dto;

import com.projeto.sistema_gerenciamento_faculdade.entity.Aluno;

public record AlunoRequestDto(String nome, int idade, String cpf, String matricula, String email) {

    public Aluno toEntity()
    {
        return new Aluno(nome, idade, cpf, matricula, email);
    }

}
