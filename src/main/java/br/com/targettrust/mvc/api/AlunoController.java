package br.com.targettrust.mvc.api;

import br.com.targettrust.mvc.model.Aluno;
import br.com.targettrust.mvc.service.AlunoService;

import java.util.List;

public class AlunoController {
    private AlunoService alunoService;
    public List<Aluno> listarAlunos(String nome) {
        return alunoService.filtrarPeloNome(nome);
    }
}
