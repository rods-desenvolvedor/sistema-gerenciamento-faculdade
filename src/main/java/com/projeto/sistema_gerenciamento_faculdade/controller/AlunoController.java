package com.projeto.sistema_gerenciamento_faculdade.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.sistema_gerenciamento_faculdade.dto.AlunoRequestDto;
import com.projeto.sistema_gerenciamento_faculdade.dto.AlunoResponseDto;
import com.projeto.sistema_gerenciamento_faculdade.service.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private AlunoService alunoService;

    AlunoController(AlunoService alunoService)
    {
        this.alunoService = alunoService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<AlunoResponseDto> cadastrarAluno(@RequestBody AlunoRequestDto alunoRequestDto)
    {
        AlunoResponseDto alunoResponseDto = alunoService.cadastrarAluno(alunoRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoResponseDto);
    }

    @PostMapping("/cadastrar/{idAluno}/{idDisciplina}")
    public ResponseEntity<HttpStatus> matricularAlunoEmDisciplina(@PathVariable("idAluno") UUID idAluno, @PathVariable("idDisciplina") UUID idDisciplina)
    {
        alunoService.cadastrarAlunoEmDisciplina(idAluno, idDisciplina);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AlunoResponseDto>> listarAlunos()
    {
        List<AlunoResponseDto> alunos = alunoService.listarAlunos();
        return ResponseEntity.ok().body(alunos);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<AlunoResponseDto> atualizarAluno(@RequestBody AlunoRequestDto alunoRequestDto, @PathVariable("id") UUID idAluno)
    {
        AlunoResponseDto aluno = alunoService.atualizarAluno(alunoRequestDto, idAluno);

        return ResponseEntity.ok().body(aluno);
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<Void> apagarAlunoPeloId(@PathVariable("id") UUID id)
    {
        alunoService.apagarAlunoPeloId(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
}
