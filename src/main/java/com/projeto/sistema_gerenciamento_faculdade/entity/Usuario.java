package com.projeto.sistema_gerenciamento_faculdade.entity;

import java.util.UUID;

import com.projeto.sistema_gerenciamento_faculdade.entity.enums.TipoUsuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    public Usuario()
    {

    }

    public Usuario(UUID id, String name, String email, String senha) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.senha = senha;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private String email;
    private String senha;

    private TipoUsuario tipoUsuario;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    


    
}
