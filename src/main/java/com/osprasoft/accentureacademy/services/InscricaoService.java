package com.osprasoft.accentureacademy.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osprasoft.accentureacademy.domain.Inscricao;
import com.osprasoft.accentureacademy.dto.InscricaoDTO;
import com.osprasoft.accentureacademy.repositories.InscricaoRepository;

@Service
public class InscricaoService {

    @Autowired
    private InscricaoRepository repo;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private CursoService cursoService;

    public Inscricao inscrever(InscricaoDTO dto) {
        Inscricao inscricao = new Inscricao();
        inscricao.setDataInscricao(new Date());
        inscricao.setAluno(alunoService.buscarPorId(dto.getAluno_id()));
        inscricao.setCurso(cursoService.buscarPorId(dto.getCurso_id()));
        return repo.save(inscricao);
    }

    public List < Inscricao > listarCursosPorAluno(Integer alunoId) {
        return repo.findByAlunoId(alunoId);
    }

    public List < Inscricao > listarAlunosPorCurso(Integer cursoId) {
        return repo.findByCursoId(cursoId);
    }

}
