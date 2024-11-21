package com.osprasoft.accentureacademy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osprasoft.accentureacademy.domain.Inscricao;

@Repository
public interface InscricaoRepository extends JpaRepository < Inscricao, Integer > {

    List < Inscricao > findCursosByAlunoId(Integer alunoId);
    List < Inscricao > findAlunosByCursoId(Integer cursoId);
}
