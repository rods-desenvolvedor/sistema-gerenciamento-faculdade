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

import com.projeto.sistema_gerenciamento_faculdade.dto.ProfessorRequestDto;
import com.projeto.sistema_gerenciamento_faculdade.dto.ProfessorResponseDto;
import com.projeto.sistema_gerenciamento_faculdade.service.ProfessorService;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    
    private ProfessorService professorService;

    ProfessorController(ProfessorService professorService)
    {
        this.professorService = professorService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ProfessorResponseDto> cadastrarProfessor(@RequestBody ProfessorRequestDto professorRequestDto)
    {
        ProfessorResponseDto professorResponseDto = professorService.cadastrarProfessor(professorRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(professorResponseDto);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ProfessorResponseDto>> listarProfessores()
    {
        return ResponseEntity.ok(professorService.listarProfessores());
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ProfessorResponseDto> atualizarProfessor(@RequestBody ProfessorRequestDto professorRequestDto,@PathVariable("id") UUID idProfessor)
    {
        ProfessorResponseDto professorResponseDto = professorService.atualizarProfessor(professorRequestDto, idProfessor);
        return ResponseEntity.ok().body(professorResponseDto);
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<Void> apagarProfessorPeloId(@PathVariable("id") UUID id)
    {
        professorService.apagarProfessorPeloId(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }




}
