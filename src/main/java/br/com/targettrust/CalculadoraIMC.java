package br.com.targettrust;

import java.math.BigDecimal;

public class CalculadoraIMC {

    public double calcularIMC(float peso, float altura, int numeroCasas) {
//        float imc = peso / (altura * altura);
        float imc = (float) (peso / Math.pow(altura, 2));
        BigDecimal bigDecimal = new BigDecimal(imc);
        imc = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        return imc;
    }

    public String classificarIMC(double imc) {
        System.out.printf("IMC: %s \n", imc);
        if (imc < 18.5) {
            return "Você está magro(a)";
        } else if (imc >= 18.5 && imc < 25) {
            return "Seu peso está normal";
        } else if (imc >= 25 && imc < 30) {
            return "Você está com sobrepeso";
        } else if (imc >= 30 && imc < 39) {
            return "Você está acima do peso";
        } else if (imc >= 40) {
            return "Você está com obsidade grave, por favor se cuide";
        }
        return "Sem classificação";
    }
}
