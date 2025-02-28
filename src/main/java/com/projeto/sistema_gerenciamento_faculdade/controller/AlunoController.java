package com.projeto.sistema_gerenciamento_faculdade.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
    
}
