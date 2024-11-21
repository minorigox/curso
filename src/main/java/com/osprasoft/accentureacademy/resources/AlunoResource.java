package com.osprasoft.accentureacademy.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.osprasoft.accentureacademy.domain.Aluno;
import com.osprasoft.accentureacademy.dto.AlunoDTO;
import com.osprasoft.accentureacademy.dto.util.InscricaoPopulator;
import com.osprasoft.accentureacademy.repositories.AlunoRepository;
import com.osprasoft.accentureacademy.services.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {

    @Autowired
    private AlunoService service;

    @Autowired
    private AlunoRepository repo;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity < AlunoDTO > find(@PathVariable Integer id) {
        Aluno obj = service.buscar(id);
        return ResponseEntity.ok().body(new AlunoDTO(obj));
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity < List < AlunoDTO >> listar() {
        List < Aluno > lista = service.listar();
        List < AlunoDTO > listaDTO = InscricaoPopulator.converteListaParaAlunoDTO(lista);
        return ResponseEntity.ok().body(listaDTO);
    }

    @PostMapping
    public ResponseEntity < Aluno > inscrever(@RequestParam String nome, @RequestParam String email) {
        Aluno aluno = new Aluno(null, nome, email, null);
        return ResponseEntity.ok(repo.save(aluno));
    }
}