package com.projeto.sistema_gerenciamento_faculdade.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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




}
