package br.com.targettrust;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    @Test
    void givenTwoDoubleNumbers_whenSomar_thenReturnCorrectResult() {
        Calculadora calculadora = new Calculadora();
        double result = calculadora.somar(2.345, 3.660);
        assertEquals(6.00, result, 0.01);
    }

    @Test
    void givenTwoDoubleNumbersWith6Digits_whenSomar_then3DigitResult() {
        Calculadora calculadora = new Calculadora();
        double result = calculadora.somar(2.345556, 3.660004);
        assertEquals(6.004, result, 0.001);
    }

    @Test
    void givenTwoDoubleNumber_whenSubtrair_thenReturnCorrectResult() {
        Calculadora calculadora = new Calculadora();
        double result = calculadora.subtrair(3.00, 2.00);
        assertEquals(1.00, result, 0.01);
    }
}