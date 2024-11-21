package com.osprasoft.accentureacademy.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.osprasoft.accentureacademy.dto.CursoDTO;
import com.osprasoft.accentureacademy.dto.util.InscricaoPopulator;
import com.osprasoft.accentureacademy.services.CursoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/cursos")
public class CursoResource {

    @Autowired  
    private CursoService service;

    @Autowired
    private InscricaoPopulator populador;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity < CursoDTO > buscar(@PathVariable Integer id) {
        CursoDTO cursoDTO = populador.converterCursoParaDto(service.buscarPorId(id));
        return ResponseEntity.ok().body(cursoDTO);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity < List < CursoDTO >> listar() {
        List < CursoDTO > listaDTO = service.listar().stream().map(obj -> populador.converterCursoParaDto(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaDTO);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity < CursoDTO > cadastrarCurso(@Valid @RequestBody CursoDTO objDTO) {
        CursoDTO cursoDTO = populador.converterCursoParaDto(service.cadastrarCurso(objDTO));
        return ResponseEntity.ok(cursoDTO);
    }
}
