package com.example.projetoPOO1202401.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "estados")

public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;

    private String nome;

    private String sigla;

    private Boolean ativo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
