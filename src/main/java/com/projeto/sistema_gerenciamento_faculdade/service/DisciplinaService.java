package com.projeto.sistema_gerenciamento_faculdade.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;


import com.projeto.sistema_gerenciamento_faculdade.dto.DisciplinaRequestDto;
import com.projeto.sistema_gerenciamento_faculdade.dto.DisciplinaResponseDto;
import com.projeto.sistema_gerenciamento_faculdade.entity.Disciplina;
import com.projeto.sistema_gerenciamento_faculdade.entity.Professor;
import com.projeto.sistema_gerenciamento_faculdade.exception.EntidadeNaoEncontradaException;
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
        /* 
        Optional<Professor>optionalProfessor = professorRepository.findById(idProfessor);

         

        if(optionalProfessor.isPresent())
        {
            Professor professor = optionalProfessor.get();
            disciplina.setProfessor(professor);
        }

        */

        Disciplina disciplina =  disciplinaRequestDto.toEntity();

        Professor professor = professorRepository.findById(idProfessor)
        .orElseThrow(() -> new EntidadeNaoEncontradaException("professor com o ID" + " " + idProfessor + 
        " " + "não encontrado."));

        disciplina.setProfessor(professor);

        
        Disciplina savedDisciplina = disciplinaRepository.save(disciplina);
        return new DisciplinaResponseDto(savedDisciplina);
    }

    public List<DisciplinaResponseDto> listarDisciplinas()
    {
        List<Disciplina> disciplinas = disciplinaRepository.findAll();
        return disciplinas.stream().map(DisciplinaResponseDto::new).toList();
    }

    public DisciplinaResponseDto atualizarDisciplina(DisciplinaRequestDto disciplinaRequestDto, UUID id)
    {
        /* 
        Disciplina disciplina = null;
        Optional<Disciplina> optionalDisciplina = disciplinaRepository.findById(id);

        if(optionalDisciplina.isPresent())
        {
            disciplina = optionalDisciplina.get();
            disciplina.setNome(disciplinaRequestDto.nome());
            disciplina.setCargaHoraria(disciplinaRequestDto.cargaHoraria());
        }

        */

        Disciplina disciplina = disciplinaRepository.findById(id)
        .orElseThrow(() -> new EntidadeNaoEncontradaException("Disciplina com ID" + " " 
        + id + " " + "não encontrada."));

        disciplina.setNome(disciplinaRequestDto.nome());
        disciplina.setCargaHoraria(disciplinaRequestDto.cargaHoraria());

        Disciplina savedDisciplina = disciplinaRepository.save(disciplina);
        return new DisciplinaResponseDto(savedDisciplina);
    }

    public void apagarDisciplinaPeloId(UUID id)
    {
        disciplinaRepository.deleteById(id);
    }   
    
}
