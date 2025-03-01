package com.projeto.sistema_gerenciamento_faculdade.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projeto.sistema_gerenciamento_faculdade.dto.ProfessorRequestDto;
import com.projeto.sistema_gerenciamento_faculdade.dto.ProfessorResponseDto;
import com.projeto.sistema_gerenciamento_faculdade.entity.Professor;
import com.projeto.sistema_gerenciamento_faculdade.repository.ProfessorRepository;

@Service
public class ProfessorService {
    

    private ProfessorRepository professorRepository;

    ProfessorService(ProfessorRepository professorRepository)
    {
        this.professorRepository = professorRepository;
    } 

    public ProfessorResponseDto cadastrarProfessor(ProfessorRequestDto professorRequestDto)
    {
        Professor professor = professorRequestDto.toEntity();
        Professor savedProfessor = professorRepository.save(professor);
        return new ProfessorResponseDto(savedProfessor);
    }

    public List<ProfessorResponseDto> listarProfessores()
    {
        List<Professor> professors = professorRepository.findAll();

        return professors.stream().map(ProfessorResponseDto::new).toList();
    }
}
