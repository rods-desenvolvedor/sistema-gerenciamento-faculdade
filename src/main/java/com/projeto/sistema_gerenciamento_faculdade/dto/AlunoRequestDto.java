package com.projeto.sistema_gerenciamento_faculdade.dto;

import com.projeto.sistema_gerenciamento_faculdade.entity.Aluno;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AlunoRequestDto(
    @NotBlank(message = "O nome do aluno não pode estar em branco!")
    String nome, 

    @NotNull(message = "A idade é obrigatória!")
    Integer idade,
    
    @NotBlank(message = "O cpf é obrigatório!")
    String cpf, 

    @NotBlank(message = "A matricula é obrigatória!")
    String matricula, 

    @NotBlank(message = "O email não pode estar em branco")
    String email) {

    public Aluno toEntity()
    {
        return new Aluno(nome, idade, cpf, matricula, email);
    }

}
