package com.osprasoft.accentureacademy.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.osprasoft.accentureacademy.domain.Curso;
import com.osprasoft.accentureacademy.dto.CursoDTO;
import com.osprasoft.accentureacademy.dto.util.InscricaoPopulator;
import com.osprasoft.accentureacademy.services.CursoService;

@RestController
@RequestMapping(value = "/cursos")
public class CursoResource {

    @Autowired
    private CursoService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity < CursoDTO > buscar(@PathVariable Integer id) {
        Curso obj = service.buscar(id);
        return ResponseEntity.ok().body(new CursoDTO(obj));
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity < List < CursoDTO >> listar() {
        List < Curso > lista = service.listar();
        List < CursoDTO > listaDTO = InscricaoPopulator.converteListaParaCursoDTO(lista);
        return ResponseEntity.ok().body(listaDTO);
    }
}
