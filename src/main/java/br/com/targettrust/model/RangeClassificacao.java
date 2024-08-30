package br.com.targettrust.model;

import java.util.Objects;

public class RangeClassificacao {
    private final double min;
    private final double max;

    public RangeClassificacao(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if(o instanceof Double) {
            return this.min <= (Double) o && (Double) o <= this.max;
        }

        if (o == null || getClass() != o.getClass()) return false;
        RangeClassificacao that = (RangeClassificacao) o;
        return Double.compare(min, that.min) == 0 && Double.compare(max, that.max) == 0;

    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }
}
