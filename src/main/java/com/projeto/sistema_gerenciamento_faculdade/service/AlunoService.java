package com.projeto.sistema_gerenciamento_faculdade.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;


import com.projeto.sistema_gerenciamento_faculdade.dto.AlunoRequestDto;
import com.projeto.sistema_gerenciamento_faculdade.dto.AlunoResponseDto;
import com.projeto.sistema_gerenciamento_faculdade.entity.Aluno;
import com.projeto.sistema_gerenciamento_faculdade.entity.Disciplina;
import com.projeto.sistema_gerenciamento_faculdade.exception.EntidadeNaoEncontradaException;
import com.projeto.sistema_gerenciamento_faculdade.repository.AlunoRepository;
import com.projeto.sistema_gerenciamento_faculdade.repository.DisciplinaRepository;

@Service
public class AlunoService {

    private AlunoRepository alunoRepository;
    private DisciplinaRepository disciplinaRepository;

    AlunoService(AlunoRepository alunoRepository, DisciplinaRepository disciplinaRepository)
    {
        this.alunoRepository = alunoRepository;
        this.disciplinaRepository = disciplinaRepository;
    }

    public AlunoResponseDto cadastrarAluno(AlunoRequestDto alunoRequestDto)
    {

        Aluno aluno = alunoRequestDto.toEntity();
        Aluno savedAluno = alunoRepository.save(aluno);
        return new AlunoResponseDto(savedAluno);
    }

    public AlunoResponseDto cadastrarAlunoEmDisciplina(UUID idAluno, UUID idDisciplina)
    {
        Aluno aluno = alunoRepository.findById(idAluno).orElseThrow(()
        -> new EntidadeNaoEncontradaException("Aluno com o ID" + idAluno + "não encontrado"));

        Disciplina disciplina = disciplinaRepository.findById(idDisciplina).orElseThrow(
            () -> new EntidadeNaoEncontradaException("Disciplina com o ID" + idDisciplina + "não encontrado"));

        aluno.getDisciplinas().add(disciplina);
        
        Aluno savedAluno = alunoRepository.save(aluno);

        return new AlunoResponseDto(savedAluno);
    }

    public List<AlunoResponseDto> listarAlunos()
    {
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos.stream().map(AlunoResponseDto::new).toList(); 
    }

    public AlunoResponseDto atualizarAluno(AlunoRequestDto alunoRequestDto, UUID idAluno)
    {

        //Optional<Aluno> optionalAluno = alunoRepository.findById(idAluno);

        //Aluno aluno = null;

        //if (optionalAluno.isPresent())
        //{
           // aluno = optionalAluno.get();
           // aluno.setNome(alunoRequestDto.nome());
           // aluno.setIdade(alunoRequestDto.idade());
       // }

       Aluno aluno = alunoRepository.findById(idAluno)
       .orElseThrow(() -> new EntidadeNaoEncontradaException("Aluno com o ID" + idAluno + "não encontrado"));

       aluno.setNome(alunoRequestDto.nome());
       aluno.setIdade(alunoRequestDto.idade());


       Aluno savedAluno = alunoRepository.save(aluno);  

       return new AlunoResponseDto(savedAluno);
    }

    public void apagarAlunoPeloId(UUID idAluno)
    {
        alunoRepository.deleteById(idAluno);
    }
    
}
