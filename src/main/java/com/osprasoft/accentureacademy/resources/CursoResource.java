package com.osprasoft.accentureacademy.resources;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.osprasoft.accentureacademy.domain.Curso;

@RestController
@RequestMapping(value = "/cursos")
public class CursoResource {
    
    @RequestMapping(method = RequestMethod.GET)
    public List < Curso > listar() {
        Curso a1 = new Curso(1, "SAP Commerce", "Curso de SAP Commerce", new Date());
        List < Curso > lista = new ArrayList<>();
        lista.add(a1);
        return lista;
    }
}
