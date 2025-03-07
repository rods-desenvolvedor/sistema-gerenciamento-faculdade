package com.projeto.sistema_gerenciamento_faculdade.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_aluno")
public class Aluno {

    public Aluno()
    {

    }

    

    public Aluno(UUID id, String nome, int idade, String cpf, String matricula, String email) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.matricula = matricula;
        this.email = email;
    }



    public Aluno(String nome, int idade, String cpf, String matricula, String email) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.matricula = matricula;
        this.email = email;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer idade;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false, unique = true)
    private String matricula;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToMany
    @JoinTable(
        name = "tb_aluno_disciplina",
        joinColumns = @JoinColumn(name = "aluno_id"),
        inverseJoinColumns = @JoinColumn(name = "disciplina_id")
    )
    private List<Disciplina> disciplinas;

    

    
    public UUID getId() {
        return id;
    }



    public void setId(UUID id) {
        this.id = id;
    }



    public String getNome() {
        return nome;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }



    public Integer getIdade() {
        return idade;
    }



    public void setIdade(int idade) {
        this.idade = idade;
    }



    public String getCpf() {
        return cpf;
    }



    public void setCpf(String cpf) {
        this.cpf = cpf;
    }



    public String getMatricula() {
        return matricula;
    }



    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }



    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    
    
}
