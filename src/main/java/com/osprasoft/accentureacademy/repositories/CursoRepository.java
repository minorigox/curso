package com.osprasoft.accentureacademy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osprasoft.accentureacademy.domain.Curso;

@Repository
public interface CursoRepository extends JpaRepository < Curso, Integer > {
}
