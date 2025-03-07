package com.projeto.sistema_gerenciamento_faculdade.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.projeto.sistema_gerenciamento_faculdade.dto.ProfessorRequestDto;
import com.projeto.sistema_gerenciamento_faculdade.dto.ProfessorResponseDto;
import com.projeto.sistema_gerenciamento_faculdade.entity.Professor;
import com.projeto.sistema_gerenciamento_faculdade.exception.EntidadeNaoEncontradaException;
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

    public void apagarProfessorPeloId(UUID id)
    {
        professorRepository.deleteById(id);
    }

    public ProfessorResponseDto atualizarProfessor(ProfessorRequestDto professorRequestDto, UUID idProfessor)
    {

        /* 
        Optional<Professor> optionalProfessor = professorRepository.findById(idProfessor);

        Professor professor = null;

        if(optionalProfessor.isPresent())
        {
            professor = optionalProfessor.get();
            professor.setNome(professorRequestDto.nome());
            professor.setIdade(professorRequestDto.idade());
        }

        */

        Professor professor = professorRepository.findById(idProfessor)
        .orElseThrow(() -> new EntidadeNaoEncontradaException("professor com ID" + " " + 
        idProfessor + " " + "não encontrado."));

        Professor savedProfessor = professorRepository.save(professor);

        return new ProfessorResponseDto(savedProfessor);
    }
}
