package br.com.targettrust;

import br.com.targettrust.model.ClassificacaoIMC;
import br.com.targettrust.model.ParametroIMCIncorretoException;
import br.com.targettrust.model.RangeClassificacao;

import java.math.BigDecimal;
import java.util.*;

public class CalculadoraIMC {
    private List<RangeClassificacao> classificacoes = List.of(
            new RangeClassificacao(18.5d, 25.99d, ClassificacaoIMC.NORMAL),
            RangeClassificacao.of(25d, 29.99d, ClassificacaoIMC.SOBREPESO),
            RangeClassificacao.of(30d, 34.99d, ClassificacaoIMC.OBESIDADE_I),
            RangeClassificacao.of(35d, 39.99d, ClassificacaoIMC.OBESIDADE_II)

    );

    public BigDecimal calcularIMC(BigDecimal peso, BigDecimal altura, int numeroCasas) {
//        float imc = peso / (altura * altura);
        if(altura.equals(BigDecimal.ZERO)) {
            throw new ParametroIMCIncorretoException();
        }

        if(altura.compareTo(new BigDecimal("3.5")) >= 0) {
            return BigDecimal.ZERO;
        }

        if(peso.compareTo(new BigDecimal("1000")) >= 0) {
            return BigDecimal.ZERO;
        }

        if(peso.compareTo(new BigDecimal("15")) <= 0) {
            return BigDecimal.ZERO;
        }

        BigDecimal imc = peso.divide(altura.pow(2), numeroCasas, BigDecimal.ROUND_HALF_UP);
        imc = imc.setScale(numeroCasas, BigDecimal.ROUND_HALF_UP);
        return imc;
    }

    public ClassificacaoIMC classificarIMC(double imc) {
        System.out.printf("IMC: %s \n", imc);

        if (imc < 18.5) {
            return ClassificacaoIMC.BAIXO_PESO;
        }
        if (imc >= 40) {
            return ClassificacaoIMC.OBESIDADE_EXTREMA;
        }

        // Optional é uma caixa que contem ou não o valor
        // Optional nunca deve ser null
        // O programador opera na caixa, como se tivesse operando no objeto
        // No final pode-se retirar o não o objeto da caixa
        Optional<RangeClassificacao> optionalRange =  classificacoes.stream().filter(range -> range.equals(imc)).findFirst();

        // Exemplos de operações com o optional

        Optional<String> nomeCom3PrimeiraLetrasELowerCase =  optionalRange
                .map(classificao -> classificao.getClassificacao())
                .map(classificaoEnum -> classificaoEnum.name())
                .map(nomeClassificacao -> nomeClassificacao.toLowerCase())
                .map(nomeClassificacao -> nomeClassificacao.substring(0, 3));

        if(nomeCom3PrimeiraLetrasELowerCase.isPresent()) {
            System.out.println("Valor presente " + nomeCom3PrimeiraLetrasELowerCase.get());
        }

//        var nomeOrStringVazia = nomeCom3PrimeiraLetrasELowerCase.orElse("");
//        nomeCom3PrimeiraLetrasELowerCase.ifPresent(System.out::println);
//        nomeCom3PrimeiraLetrasELowerCase.orElseThrow(() -> new ParametroIMCIncorretoException());



        return optionalRange
               // .map(classificacao -> classificacao.getClassificacao())
                .map(RangeClassificacao::getClassificacao) // igual a linha 77
                .orElse(ClassificacaoIMC.SEM_CLASSIFICACAO);
    }

    public void exemploIdeiaRemoverIf() {
        Map<RangeClassificacao, ClassificacaoIMC> classificacoes = new HashMap<>();
        var classificacao = classificacoes.get(20.0);
        List<RangeClassificacao> ranges = List.of(new RangeClassificacao(10, 20, ClassificacaoIMC.SEM_CLASSIFICACAO), new RangeClassificacao(40, 50, ClassificacaoIMC.SEM_CLASSIFICACAO));

        ranges.contains(15);

    }

    public void exemploListMapSet() {
        // Tabela com chave e valor
        // importante a chave não colidir
        Map<String, String> exemploMap = new HashMap<>();
        // sempre rapido
        exemploMap.get("a");
        // sempre rapido
        exemploMap.put("a", "b");
        exemploMap.put("---eee-s-s-", "c");

        String[] lista = new String[100];
        String [] lista2 = new String[200];
        // Uma lista de strings infinita
        List<String> lista3 = new ArrayList<>();
        List<String> lista4 = new LinkedList<>();
        // bem lento
        lista4.get(100000000);
        // Pode ser rapido, ou nem tanto
        lista4.add("novo item");
        // Uma lista que não se repete. Ou uma lista que remove duplicados.
        Set<String> set = new HashSet<>();
    }
}
