package com.projeto.sistema_gerenciamento_faculdade.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<String> handleEntidadeNaoEncontradaException(EntidadeNaoEncontradaException ex)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }   

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
    List<String> erros = ex.getBindingResult()
        .getFieldErrors()
        .stream()
        .map(error -> error.getField() + ": " + error.getDefaultMessage())
        .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
    }

    
}
