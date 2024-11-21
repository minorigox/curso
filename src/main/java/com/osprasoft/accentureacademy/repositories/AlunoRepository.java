package com.osprasoft.accentureacademy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osprasoft.accentureacademy.domain.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository < Aluno, Integer > {
}
