package br.com.targettrust;

import br.com.targettrust.model.ClassificacaoIMC;
import br.com.targettrust.model.RangeClassificacao;

import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        var range1 = new RangeClassificacao(10, 20, ClassificacaoIMC.SEM_CLASSIFICACAO);
        List<RangeClassificacao> ranges = List.of(range1, new RangeClassificacao(40, 50, ClassificacaoIMC.SEM_CLASSIFICACAO));
        var equals = range1.equals(15d);
        var contains = ranges.contains(15d);
        List.of(new RangeClassificacao(10, 20, ClassificacaoIMC.SEM_CLASSIFICACAO), new RangeClassificacao(15, 18, ClassificacaoIMC.SEM_CLASSIFICACAO)).contains(15d);
        var contains2 = ranges.stream().anyMatch(range -> range.equals(15d));

        var range = ranges.stream().filter(rangef -> rangef.equals(15d)).findFirst();
        var equalsObject = Objects.equals(15d, range1);
        var equalObjectInvertido = Objects.equals(range1, 15d);

        System.out.println(contains);
    }
}