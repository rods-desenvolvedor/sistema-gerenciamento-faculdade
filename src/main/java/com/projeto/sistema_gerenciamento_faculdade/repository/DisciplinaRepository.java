package com.projeto.sistema_gerenciamento_faculdade.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.sistema_gerenciamento_faculdade.entity.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, UUID>{

}
