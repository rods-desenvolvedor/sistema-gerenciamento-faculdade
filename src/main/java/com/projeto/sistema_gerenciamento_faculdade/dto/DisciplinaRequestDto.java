package com.projeto.sistema_gerenciamento_faculdade.dto;

import com.projeto.sistema_gerenciamento_faculdade.entity.Disciplina;

public record DisciplinaRequestDto(String nome, int cargaHoraria) {

    public Disciplina toEntity()
    {
        return new Disciplina(nome, cargaHoraria);
    }

}
