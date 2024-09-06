package br.com.targettrust.mvc.service;

import br.com.targettrust.mvc.model.Aluno;

import java.util.List;

public interface AlunoService {
    List<Aluno> filtrarPeloNome(String nome);
}
