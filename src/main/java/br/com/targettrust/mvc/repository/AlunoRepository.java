package br.com.targettrust.mvc.repository;

import br.com.targettrust.mvc.model.Aluno;

import java.util.List;

public interface AlunoRepository {
    List<Aluno> listarAlunosMatriculasPeloNome(String nome);

    List<Aluno> listaAlunoMatriculado();
}
