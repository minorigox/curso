package com.osprasoft.accentureacademy.dto;

import java.io.Serializable;
import java.util.Date;

import com.osprasoft.accentureacademy.domain.Curso;

public class CursoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nome;
    private String descricao;
    private Date dataCriacao;

    public CursoDTO(Curso curso) {
        this.id = curso.getId();
        this.nome = curso.getNome();
        this.descricao = curso.getDescricao();
        this.dataCriacao = curso.getDataCriacao();
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Date getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }   
}