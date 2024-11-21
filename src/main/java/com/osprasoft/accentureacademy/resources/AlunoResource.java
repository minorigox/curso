package com.osprasoft.accentureacademy.resources;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.osprasoft.accentureacademy.dto.AlunoDTO;
import com.osprasoft.accentureacademy.dto.util.InscricaoPopulator;
import com.osprasoft.accentureacademy.services.AlunoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {

    @Autowired
    private AlunoService service;

    @Autowired
    private InscricaoPopulator populador;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity < AlunoDTO > find(@PathVariable Integer id) {
        AlunoDTO alunoDTO = populador.converterAlunoParaDto(service.buscarPorId(id));
        return ResponseEntity.ok().body(alunoDTO);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity < List < AlunoDTO >> findAll() {
        List < AlunoDTO > listaDTO = service.listar().stream().map(obj -> populador.converterAlunoParaDto(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaDTO);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity < AlunoDTO > insert(@Valid @RequestBody AlunoDTO objDTO) {
        AlunoDTO alunoDTO = populador.converterAlunoParaDto(service.cadastrarAluno(objDTO));
        return ResponseEntity.ok(alunoDTO);  
    }
}