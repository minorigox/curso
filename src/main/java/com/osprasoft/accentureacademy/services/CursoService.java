package com.osprasoft.accentureacademy.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osprasoft.accentureacademy.domain.Curso;
import com.osprasoft.accentureacademy.dto.CursoDTO;
import com.osprasoft.accentureacademy.dto.util.InscricaoPopulator;
import com.osprasoft.accentureacademy.repositories.CursoRepository;

@Service
public class CursoService {
    
    @Autowired
    private CursoRepository repo;

    @Autowired
    private InscricaoPopulator populador;

    public Curso buscarPorId(Integer id) {
        Optional < Curso > obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Curso não encontrado! ID: ", id));
    }

    public List < Curso > listar() {
        return repo.findAll();
    }

    public Curso cadastrarCurso(CursoDTO objDTO) {
        Curso curso = populador.converterDtoParaCurso(objDTO);
        return repo.save(curso);
    }
}
