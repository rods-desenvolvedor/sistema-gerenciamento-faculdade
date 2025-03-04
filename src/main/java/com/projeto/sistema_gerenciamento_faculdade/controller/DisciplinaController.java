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

import com.projeto.sistema_gerenciamento_faculdade.dto.DisciplinaRequestDto;
import com.projeto.sistema_gerenciamento_faculdade.dto.DisciplinaResponseDto;
import com.projeto.sistema_gerenciamento_faculdade.service.DisciplinaService;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    private DisciplinaService disciplinaService;

    DisciplinaController(DisciplinaService disciplinaService)
    {
        this.disciplinaService = disciplinaService;
    }

    @PostMapping("/cadastrar/{id}")
    public ResponseEntity<DisciplinaResponseDto> cadastrarDisciplina(@RequestBody DisciplinaRequestDto disciplinaRequestDto,@PathVariable("id") UUID idProfessor)
    {
        DisciplinaResponseDto disciplinaResponseDto = disciplinaService.cadastrarDisciplina(disciplinaRequestDto, idProfessor);
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaResponseDto);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<DisciplinaResponseDto>> listarDisciplinas()
    {
        List<DisciplinaResponseDto> disciplinas = disciplinaService.listarDisciplinas();
        return ResponseEntity.ok().body(disciplinas);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<DisciplinaResponseDto> atualizarDisciplina(@RequestBody DisciplinaRequestDto disciplinaRequestDto,@PathVariable("id") UUID id)
    {
        DisciplinaResponseDto disciplinaResponseDto = disciplinaService.atualizarDisciplina(disciplinaRequestDto, id);
        return ResponseEntity.ok().body(disciplinaResponseDto);
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<Void> apagarDisciplinaPeloId(@PathVariable("id") UUID id)
    {
        disciplinaService.apagarDisciplinaPeloId(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
}
