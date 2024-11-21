package com.osprasoft.accentureacademy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osprasoft.accentureacademy.domain.Inscricao;

public interface InscricaoRepository extends JpaRepository < Inscricao, Integer > {

    List < Inscricao > findAlunoById(Integer alunoId);
    List < Inscricao > findCursoById(Integer cursoId);
}
