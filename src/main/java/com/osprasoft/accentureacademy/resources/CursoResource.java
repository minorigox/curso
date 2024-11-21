package com.osprasoft.accentureacademy.resources;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.osprasoft.accentureacademy.domain.Curso;
import com.osprasoft.accentureacademy.services.CursoService;

@RestController
@RequestMapping(value = "/cursos")
public class CursoResource {

    @Autowired
    private CursoService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity < Curso > find(@PathVariable Integer id) {
        Curso obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public List < Curso > listar() {
        Curso a1 = new Curso(1, "SAP Commerce", "Curso de SAP Commerce", new Date());
        List < Curso > lista = new ArrayList<>();
        lista.add(a1);
        return lista;
    }
}
