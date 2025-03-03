package com.projeto.sistema_gerenciamento_faculdade.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.projeto.sistema_gerenciamento_faculdade.dto.DisciplinaRequestDto;
import com.projeto.sistema_gerenciamento_faculdade.dto.DisciplinaResponseDto;
import com.projeto.sistema_gerenciamento_faculdade.entity.Disciplina;
import com.projeto.sistema_gerenciamento_faculdade.entity.Professor;
import com.projeto.sistema_gerenciamento_faculdade.repository.DisciplinaRepository;
import com.projeto.sistema_gerenciamento_faculdade.repository.ProfessorRepository;

@Service
public class DisciplinaService {

    private DisciplinaRepository disciplinaRepository;
    private ProfessorRepository professorRepository;

    DisciplinaService(DisciplinaRepository disciplinaRepository, ProfessorRepository professorRepository)
    {
        this.disciplinaRepository = disciplinaRepository;
        this.professorRepository = professorRepository;
    }

    public DisciplinaResponseDto cadastrarDisciplina(DisciplinaRequestDto disciplinaRequestDto, UUID idProfessor)
    {   
        Optional<Professor>optionalProfessor = professorRepository.findById(idProfessor);

        Disciplina disciplina =  disciplinaRequestDto.toEntity(); 

        if(optionalProfessor.isPresent())
        {
            Professor professor = optionalProfessor.get();
            disciplina.setProfessor(professor);
        }

        
        Disciplina savedDisciplina = disciplinaRepository.save(disciplina);
        return new DisciplinaResponseDto(savedDisciplina);
    }
    
}
