package br.com.targettrust;

import br.com.targettrust.model.ClassificacaoIMC;
import br.com.targettrust.model.ParametroIMCIncorretoException;

import java.math.BigDecimal;

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
}
