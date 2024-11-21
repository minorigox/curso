package com.osprasoft.accentureacademy.resources;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.osprasoft.accentureacademy.dto.AlunoDTO;
import com.osprasoft.accentureacademy.dto.CursoDTO;
import com.osprasoft.accentureacademy.dto.InscricaoDTO;
import com.osprasoft.accentureacademy.dto.util.InscricaoPopulator;
import com.osprasoft.accentureacademy.services.InscricaoService;

@RestController
@RequestMapping(value = "/inscricao")
public class InscricaoResource {
  
    @Autowired
    private InscricaoService service;

    @Autowired
    private InscricaoPopulator populador;

    @PostMapping
    public ResponseEntity < Void > inscrever(@RequestBody InscricaoDTO dto) {
        service.inscrever(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(value = "/aluno/{alunoId}", method = RequestMethod.GET)
    public ResponseEntity < List < CursoDTO >> listarCursosPorAluno(@PathVariable Integer alunoId) {
        List < CursoDTO > cursosDTO = service.listarCursosPorAluno(alunoId).stream().map(obj -> populador.converterCursoParaDto(obj.getCurso())).collect(Collectors.toList());
        return ResponseEntity.ok(cursosDTO);
    }

    @RequestMapping(value = "/curso/{cursoId}", method = RequestMethod.GET)
    public ResponseEntity < List < AlunoDTO >> listarAlunosCurso(@PathVariable Integer cursoId) {
        List < AlunoDTO > alunosDTO = service.listarAlunosPorCurso(cursoId).stream().map(obj -> populador.converterAlunoParaDto(obj.getAluno())).collect(Collectors.toList());
        return ResponseEntity.ok(alunosDTO);
    }
}