package com.osprasoft.accentureacademy.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osprasoft.accentureacademy.domain.Aluno;
import com.osprasoft.accentureacademy.dto.AlunoDTO;
import com.osprasoft.accentureacademy.dto.util.InscricaoPopulator;
import com.osprasoft.accentureacademy.repositories.AlunoRepository;

@Service
public class AlunoService {
    
    @Autowired
    private AlunoRepository repo;

    @Autowired
    private InscricaoPopulator populador;

    public Aluno buscarPorId(Integer id) {
        Optional < Aluno > obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Aluno não encontrado! ID: ", id));
    }

    public List < Aluno > listar() {
        return repo.findAll();
    }

    public Aluno cadastrarAluno(AlunoDTO objDTO) {
        Aluno aluno = populador.converterDtoParaAluno(objDTO);
        return repo.save(aluno);
    }
}
