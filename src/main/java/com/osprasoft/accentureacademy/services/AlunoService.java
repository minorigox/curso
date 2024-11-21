package com.osprasoft.accentureacademy.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osprasoft.accentureacademy.domain.Aluno;
import com.osprasoft.accentureacademy.repositories.AlunoRepository;

@Service
public class AlunoService {
    
    @Autowired
    private AlunoRepository repo;

    public Aluno find(Integer id) {
        Optional < Aluno > obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Aluno não encontrado! ID: ", id));
    }
}
