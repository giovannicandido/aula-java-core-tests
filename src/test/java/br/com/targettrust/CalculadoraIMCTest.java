package br.com.targettrust;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraIMCTest {

    @Test
    void calcularIMC() {
        CalculadoraIMC calculadoraIMC = new CalculadoraIMC();
        var result = calculadoraIMC.calcularIMC(82.0f, 1.75f, 2);
        assertEquals(26.78f, result, 0.01);

    }

    @Test
    void calcularIMC_scenario2() {
        CalculadoraIMC calculadoraIMC = new CalculadoraIMC();
        var result = calculadoraIMC.calcularIMC(82.0f, 1.75f, 2);
        assertEquals(26.78f, result, 0.01);

    }

    @Test
    void classificarIMC() {
        CalculadoraIMC calculadoraIMC = new CalculadoraIMC();
        var result = calculadoraIMC.classificarIMC(17.0f);
        assertEquals("Você está magro(a)", result);
    }
}
