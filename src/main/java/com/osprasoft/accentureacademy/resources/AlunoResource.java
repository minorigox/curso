package com.osprasoft.accentureacademy.resources;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.osprasoft.accentureacademy.domain.Aluno;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {
    
    @RequestMapping(method = RequestMethod.GET)
    public List < Aluno > listar() {
        Aluno a1 = new Aluno(1, "Pedro de Lara", "pedrodelara@ig.com.br", new Date());
        List < Aluno > lista = new ArrayList<>();
        lista.add(a1);
        return lista;
    }
}
