package br.com.targettrust;

import br.com.targettrust.model.ClassificacaoIMC;
import br.com.targettrust.model.ParametroIMCIncorretoException;
import br.com.targettrust.model.RangeClassificacao;

import java.math.BigDecimal;
import java.util.*;

public class CalculadoraIMC {

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
        } else if (imc >= 18.5 && imc < 25) {
            return ClassificacaoIMC.NORMAL;
        } else if (imc >= 25 && imc < 30) {
            return ClassificacaoIMC.SOBREPESO;
        } else if (imc >= 30 && imc < 35) {
            return ClassificacaoIMC.OBESIDADE_I;
        } else if (imc >= 35 && imc < 40) {
            return ClassificacaoIMC.OBESIDADE_II;
        } else if (imc >= 40) {
            return ClassificacaoIMC.OBESIDADE_EXTREMA;
        }
        return ClassificacaoIMC.SEM_CLASSIFICACAO;
    }

    public void exemploIdeiaRemoverIf() {
        Map<RangeClassificacao, ClassificacaoIMC> classificacoes = new HashMap<>();
        var classificacao = classificacoes.get(17.0);
    }

    public void exemploListMapSet() {
        // Tabela com chave e valor
        // importante a chave não colidir
        Map<String, String> exemploMap = new HashMap<>();
        // sempre rapido
        exemploMap.get("a");
        // sempre rapido
        exemploMap.put("a", "b");
        exemploMap.put("a", "c");

        // Uma lista de strings infinita
        List<String> lista = new LinkedList<>();
        // bem lento
        lista.get(100000000);
        // Pode ser rapido, ou nem tanto
        lista.add("novo item");
        // Uma lista que não se repete. Ou uma lista que remove duplicados.
        Set<String> set = new HashSet<>();
    }
}
