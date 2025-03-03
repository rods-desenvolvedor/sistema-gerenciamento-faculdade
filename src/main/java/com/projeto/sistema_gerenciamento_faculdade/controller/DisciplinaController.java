package com.projeto.sistema_gerenciamento_faculdade.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import com.projeto.sistema_gerenciamento_faculdade.dto.DisciplinaRequestDto;
import com.projeto.sistema_gerenciamento_faculdade.dto.DisciplinaResponseDto;
import com.projeto.sistema_gerenciamento_faculdade.service.DisciplinaService;

import jakarta.websocket.server.PathParam;

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
    
}
