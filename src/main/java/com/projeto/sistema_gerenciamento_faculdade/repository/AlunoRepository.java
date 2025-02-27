package com.projeto.sistema_gerenciamento_faculdade.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.sistema_gerenciamento_faculdade.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, UUID>{

}
