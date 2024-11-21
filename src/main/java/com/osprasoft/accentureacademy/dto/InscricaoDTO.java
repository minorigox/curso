package com.osprasoft.accentureacademy.dto;

import java.io.Serializable;
import java.util.Date;

import jakarta.validation.constraints.NotEmpty;

public class InscricaoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório.")
    private Integer aluno_id;

    @NotEmpty(message = "Preenchimento obrigatório.")
    private Integer curso_id;
    private Date dataInscricao;

    public InscricaoDTO(Integer id, Integer aluno_id, Integer curso_id, Date dataInscricao) {
        this.id = id;
        this.aluno_id = aluno_id;
        this.curso_id = curso_id;
        this.dataInscricao = dataInscricao;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getAluno_id() {
        return aluno_id;
    }
    public void setAluno_id(Integer aluno_id) {
        this.aluno_id = aluno_id;
    }
    public Integer getCurso_id() {
        return curso_id;
    }
    public void setCurso_id(Integer curso_id) {
        this.curso_id = curso_id;
    }
    public Date getDataInscricao() {
        return dataInscricao;
    }
    public void setDataInscricao(Date dataInscricao) {
        this.dataInscricao = dataInscricao;
    }   
}