package com.osprasoft.accentureacademy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osprasoft.accentureacademy.domain.Inscricao;

@Repository
public interface InscricaoRepository extends JpaRepository < Inscricao, Integer > {

    List < Inscricao > findByAlunoId(Integer alunoId);
    List < Inscricao > findByCursoId(Integer cursoId);
}
