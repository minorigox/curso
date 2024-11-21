package com.osprasoft.accentureacademy.dto;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.osprasoft.accentureacademy.domain.Aluno;

import jakarta.validation.constraints.NotEmpty;

public class AlunoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório.")
    @Length(min = 3, max = 80, message = "O tamanho deve ser entre 3 e 80 caracteres.")
    private String nome;

    @NotEmpty(message = "Preenchimento obrigatório.")
    private String email;
    private Date dataCadastro;
    
    public AlunoDTO(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.email = aluno.getEmail();
        this.dataCadastro = aluno.getDataCadastro();
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }   
}