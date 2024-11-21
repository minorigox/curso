package com.osprasoft.accentureacademy.dto.util;

import java.util.List;
import java.util.stream.Collectors;

import com.osprasoft.accentureacademy.domain.Aluno;
import com.osprasoft.accentureacademy.domain.Curso;
import com.osprasoft.accentureacademy.dto.AlunoDTO;
import com.osprasoft.accentureacademy.dto.CursoDTO;

public class InscricaoPopulator {
    
    public static List < AlunoDTO > converteListaParaAlunoDTO(List < Aluno > alunos) {
        List < AlunoDTO > alunosDTO = alunos.stream().map(
            obj -> new AlunoDTO(obj)).collect(Collectors.toList());
        return alunosDTO;
    }

    public static List < CursoDTO > converteListaParaCursoDTO(List < Curso > cursos) {
        List < CursoDTO > cursosDTO = cursos.stream().map(
            obj -> new CursoDTO(obj)).collect(Collectors.toList());
        return cursosDTO;
    }
}
