package com.projeto.sistema_gerenciamento_faculdade.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.projeto.sistema_gerenciamento_faculdade.dto.AlunoRequestDto;
import com.projeto.sistema_gerenciamento_faculdade.dto.AlunoResponseDto;
import com.projeto.sistema_gerenciamento_faculdade.entity.Aluno;
import com.projeto.sistema_gerenciamento_faculdade.repository.AlunoRepository;

public class AlunoServiceTest {

    @Mock
    private AlunoRepository alunoRepository;
    
    @InjectMocks
    private AlunoService alunoService;

    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.openMocks(this);
    }



    @Test
    public void cadastrarAlunoTest()
    {
        AlunoRequestDto alunoRequestDto = new AlunoRequestDto("Pedro Teste", 220
        , "12345678901", "mat123", "pedro.teste@email.com");

        Aluno alunoSalvo = new Aluno(
            UUID.randomUUID(), "Pedro Teste", 220
        , "12345678901", "mat123", "pedro.teste@email.com"
        );

        when(alunoRepository.save(any(Aluno.class))).thenReturn(alunoSalvo);

        AlunoResponseDto alunoResponseDto = alunoService.cadastrarAluno(alunoRequestDto);

        verify(alunoRepository).save(any(Aluno.class));

        assertEquals(alunoRequestDto.nome(), alunoResponseDto.nome());
        assertEquals(alunoRequestDto.email(), alunoResponseDto.email());
    }
}
