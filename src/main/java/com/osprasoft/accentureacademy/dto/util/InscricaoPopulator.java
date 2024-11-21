package com.osprasoft.accentureacademy.dto.util;

import org.springframework.stereotype.Component;

import com.osprasoft.accentureacademy.domain.Aluno;
import com.osprasoft.accentureacademy.domain.Curso;
import com.osprasoft.accentureacademy.dto.AlunoDTO;
import com.osprasoft.accentureacademy.dto.CursoDTO;

@Component
public class InscricaoPopulator {
    
    public AlunoDTO converterAlunoParaDto(Aluno aluno) {
        AlunoDTO dto = new AlunoDTO();
        dto.setId(aluno.getId());
        dto.setNome(aluno.getNome());
        dto.setEmail(aluno.getEmail());
        dto.setDataCadastro(aluno.getDataCadastro());
        return dto;
    }

    public Aluno converterDtoParaAluno(AlunoDTO dto) {
        Aluno aluno = new Aluno();
        aluno.setId(dto.getId());
        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setDataCadastro(dto.getDataCadastro());
        return aluno;
    }

    public CursoDTO converterCursoParaDto(Curso curso) {
        CursoDTO dto = new CursoDTO();
        dto.setId(curso.getId());
        dto.setNome(curso.getNome());
        dto.setDescricao(curso.getDescricao());
        dto.setDataCriacao(curso.getDataCriacao());
        return dto;
    }
    
    public Curso converterDtoParaCurso(CursoDTO dto) {
        Curso curso = new Curso();
        curso.setId(dto.getId());
        curso.setNome(dto.getNome());
        curso.setDescricao(dto.getDescricao());
        curso.setDataCriacao(dto.getDataCriacao());
        return curso;
    }

}
