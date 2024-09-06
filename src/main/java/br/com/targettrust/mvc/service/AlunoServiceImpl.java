package br.com.targettrust.mvc.service;

import br.com.targettrust.mvc.model.Aluno;
import br.com.targettrust.mvc.repository.AlunoRepository;

import java.util.List;

public class AlunoServiceImpl implements AlunoService {

    private AlunoRepository alunoRepository;

    @Override
    public List<Aluno> filtrarPeloNome(String nome) {
        // procurar somente ativos?
        return alunoRepository.listaAlunoMatriculado()
                .stream().filter(
                        aluno -> nome.equalsIgnoreCase(aluno.getNome())
                ).toList();
    }
}
