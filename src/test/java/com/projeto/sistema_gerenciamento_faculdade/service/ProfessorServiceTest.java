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

import com.projeto.sistema_gerenciamento_faculdade.dto.ProfessorRequestDto;
import com.projeto.sistema_gerenciamento_faculdade.dto.ProfessorResponseDto;
import com.projeto.sistema_gerenciamento_faculdade.entity.Professor;
import com.projeto.sistema_gerenciamento_faculdade.repository.ProfessorRepository;

public class ProfessorServiceTest {

    @Mock
    private ProfessorRepository professorRepository;

    @InjectMocks
    private ProfessorService professorService;

    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void cadastrarProfessorTest()
    {
        ProfessorRequestDto professorRequestDto = new ProfessorRequestDto("professor teste", 45,
         "12345678902", "professor.teste@email.com", null);

        Professor savedProfessor = new Professor(UUID.randomUUID(),"professor teste", 45,
         "12345678902", "professor.teste@email.com", null);

        when(professorRepository.save(any(Professor.class))).thenReturn(savedProfessor);

        ProfessorResponseDto professorResponseDto = professorService.cadastrarProfessor(professorRequestDto);

        verify(professorRepository).save(any(Professor.class));

        assertEquals(professorRequestDto.nome(), professorResponseDto.nome());
    }
    
}
