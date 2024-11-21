package com.osprasoft.accentureacademy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osprasoft.accentureacademy.domain.Curso;
import com.osprasoft.accentureacademy.repositories.CursoRepository;

@Service
public class CursoService {
    
    @Autowired
    private CursoRepository repo;

    public Curso buscar(Integer id) {
        Optional < Curso > obj = repo.findById(id);
        return obj.orElse(null);
    }    
}
