package br.com.targettrust.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class RangeClassificacaoTest {

    @Test
    void testEqualsWithRange() {
        RangeClassificacao range1 = new RangeClassificacao(10.0d, 25.45d);
        RangeClassificacao range2 = new RangeClassificacao(10.0d, 25.45d);
        assertThat(range1).isEqualTo(range2);

        RangeClassificacao range3 = new RangeClassificacao(9.0d, 25.45d);

        assertThat(range1).isNotEqualTo(range3);
        assertThat(range2).isNotEqualTo(range3);

    }

    @Test
    void testEqualsWithDouble() {
        RangeClassificacao range1 = new RangeClassificacao(10.0d, 25.45d);
        List<Double> valuesInRange = List.of(12.34d, 20d, 25d, 25.45d);

        valuesInRange.forEach(((value) -> assertThat(range1).isEqualTo(value)));
    }

    @Test
    void testNotEqualsWithDouble() {
        RangeClassificacao range1 = new RangeClassificacao(10.0d, 25.45d);
        List<Double> valuesInRange = List.of(9d, 9.5, 26d, 27d);
        valuesInRange.forEach(((value) -> assertThat(range1).isNotEqualTo(value)));
    }
}