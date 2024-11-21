package com.osprasoft.accentureacademy.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.osprasoft.accentureacademy.domain.Aluno;
import com.osprasoft.accentureacademy.domain.Curso;
import com.osprasoft.accentureacademy.domain.Inscricao;
import com.osprasoft.accentureacademy.repositories.InscricaoRepository;
import com.osprasoft.accentureacademy.services.AlunoService;
import com.osprasoft.accentureacademy.services.CursoService;

@RestController
@RequestMapping(value = "/inscricao")
public class InscricaoResource {
  
    @Autowired
    private InscricaoRepository repo;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity < Inscricao > inscrever(@RequestParam Integer alunoId, @RequestParam Integer cursoId) {
        Aluno aluno = alunoService.buscar(alunoId);
        Curso curso = cursoService.buscar(cursoId);
        Inscricao inscricao = new Inscricao();
        inscricao.setAluno(aluno);
        inscricao.setCurso(curso);
        return ResponseEntity.ok(repo.save(inscricao));
    }

    @GetMapping("/alunos/{alunoId}")
    public ResponseEntity < List < Curso >> listarCursosAluno(@PathVariable Integer alunoId) {
        List < Inscricao > inscricoes = repo.findCursosByAlunoId(alunoId);
        List < Curso > cursos = inscricoes.stream().map(Inscricao::getCurso).toList();
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/cursos/{cursoId}")
    public ResponseEntity < List < Aluno >> listarAlunosCurso(@PathVariable Integer cursoId) {
        List < Inscricao > inscricoes = repo.findAlunosByCursoId(cursoId);
        List < Aluno > alunos = inscricoes.stream().map(Inscricao::getAluno).toList();
        return ResponseEntity.ok(alunos);
    }
}
