package br.com.targettrust.mvc.repository;

import br.com.targettrust.mvc.model.Aluno;

import java.util.List;

public class AlunoRepositoryPostgresImpl implements AlunoRepository {
    @Override
    public List<Aluno> listarAlunosMatriculasPeloNome(String nome) {
        return List.of();
    }

    @Override
    public List<Aluno> listaAlunoMatriculado() {
        return List.of();
    }
}
