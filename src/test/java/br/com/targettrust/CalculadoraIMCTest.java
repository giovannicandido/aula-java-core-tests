package br.com.targettrust;

import br.com.targettrust.model.ClassificacaoIMC;
import br.com.targettrust.model.ParametroIMCIncorretoException;
import org.assertj.core.data.Offset;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.math.BigDecimal;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


public class CalculadoraIMCTest {

    @Test
    @DisplayName("Should calculate IMC for mid weight person")
    void calcularIMC() {
        CalculadoraIMC calculadoraIMC = new CalculadoraIMC();
        var result = calculadoraIMC.calcularIMC(BigDecimal.valueOf(82.0f), BigDecimal.valueOf(1.75f), 2);
        assertThat(result).isCloseTo(BigDecimal.valueOf(26.78d), Percentage.withPercentage(1));
        assertThat("teste").contains("tes");

    }


    @Test
    void calcularIMC_scenario2() {
        CalculadoraIMC calculadoraIMC = new CalculadoraIMC();
        var result = calculadoraIMC.calcularIMC(BigDecimal.valueOf(82), new BigDecimal("1.75"), 2);
        assertThat(result).isCloseTo(new BigDecimal("26.78"), Percentage.withPercentage(0.1));

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/imc.CSV", numLinesToSkip = 1)
    void calcularIMCHappyPath(BigDecimal peso, BigDecimal altura, BigDecimal resultadoEsperado) {
        CalculadoraIMC calculadoraIMC = new CalculadoraIMC();
        var result = calculadoraIMC.calcularIMC(peso, altura, 8);
        assertThat(result).isCloseTo(resultadoEsperado, Offset.offset(BigDecimal.valueOf(0.000000001)));
    }

    @Test
    void calcularDivideByZero() {
        CalculadoraIMC calculadoraIMC = new CalculadoraIMC();

        Assertions.assertThrows(ParametroIMCIncorretoException.class, () -> {
            calculadoraIMC.calcularIMC(new BigDecimal("50.0"), BigDecimal.ZERO, 8);
        });

    }


    /**
     * Teste sera repetido com os valores de cada string separados por ,
     */
    @ParameterizedTest
    @CsvSource({"82.00,1.75,26.78", "80.00,1.79,24.96", "75.00,1.65,27.54"})
    void calcularIMC_scenario_valores_corretos(BigDecimal peso, BigDecimal altura, BigDecimal resultadoEsperado) {
        CalculadoraIMC calculadoraIMC = new CalculadoraIMC();
        var result = calculadoraIMC.calcularIMC(peso, altura, 2);
        assertThat(result).isCloseTo(resultadoEsperado, Percentage.withPercentage(0.1));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/imc-fail.csv", numLinesToSkip = 1)
    void givenInvalidParametersWhenCalcularShouldReturnZero(BigDecimal peso, BigDecimal altura) {
        CalculadoraIMC calculadoraIMC = new CalculadoraIMC();
        var result = calculadoraIMC.calcularIMC(peso, altura, 2);
        assertThat(result).isCloseTo(BigDecimal.ZERO, Percentage.withPercentage(0.01));
    }

    @ParameterizedTest
    @MethodSource("calculoIMCOutliner")
    @Disabled
    void calcularIMCOutliner(BigDecimal peso, BigDecimal altura, BigDecimal resultadoEsperado) {
        CalculadoraIMC calculadoraIMC = new CalculadoraIMC();
        var result = calculadoraIMC.calcularIMC(peso, altura, 2);
        assertThat(result).isCloseTo(resultadoEsperado, Percentage.withPercentage(0.1));
    }

    // Gerando aleatoriamente os resultados, não é previsiviel, ou seja o teste pode falhar aleatoriamente.
    private static Stream<Arguments> calculoIMCOutliner() {
        Random random = new Random();
        return IntStream.range(1, 100)
                .mapToObj(valor -> Arguments.of(random.nextFloat() * 1000, random.nextFloat() * 1000, 0.0d));

    }

    @Test
    void classificarIMC() {
        CalculadoraIMC calculadoraIMC = new CalculadoraIMC();
        var result = calculadoraIMC.classificarIMC(17.0f);
        assertThat(result).isEqualTo(ClassificacaoIMC.BAIXO_PESO);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/imc.CSV", numLinesToSkip = 1)
    void givenValidIMCParameters_whenClassificar_shouldReturnCorretValue(BigDecimal peso, BigDecimal altura,
                                                                         BigDecimal resultadoEsperado,
                                                                         String classificacaoEsperada) {
        CalculadoraIMC calculadoraIMC = new CalculadoraIMC();

        ClassificacaoIMC classificacaoIMC = ClassificacaoIMC.valueOf(classificacaoEsperada);

        var imc = calculadoraIMC.calcularIMC(peso, altura, 2);
        var result = calculadoraIMC.classificarIMC(imc.floatValue());
        assertThat(result).isEqualTo(classificacaoIMC);
    }
}
