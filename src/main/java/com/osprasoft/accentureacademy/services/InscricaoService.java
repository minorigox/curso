package com.osprasoft.accentureacademy.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osprasoft.accentureacademy.domain.Inscricao;
import com.osprasoft.accentureacademy.repositories.InscricaoRepository;

@Service
public class InscricaoService {

    @Autowired
    private InscricaoRepository repo;

    public Inscricao buscar(Integer id) {
        Optional < Inscricao > obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Curso não encontrado! ID: ", id));
    }

}
