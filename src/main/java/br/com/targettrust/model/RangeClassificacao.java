package br.com.targettrust.model;

import java.util.Objects;

public class RangeClassificacao {
    private final double min;
    private final double max;
    private final ClassificacaoIMC classificacao;

    public RangeClassificacao(double min, double max, ClassificacaoIMC classificacao) {
        this.min = min;
        this.max = max;
        this.classificacao = classificacao;
    }

    public static RangeClassificacao of(double min, double max, ClassificacaoIMC classificacaoIMC) {
        return new RangeClassificacao(min, max, classificacaoIMC);
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
        // md5 -> não é seguro. depreciado
        // sha1 -> recomendado, quase depreciado
        // sha256 -> estado da arte
        // sha384 -> Militar
        // sha512 -> Militar

        // "abcdefgh" -> 9c56cc51b374c3ba189210d5b6d4bf57790d351c96c47c02190ecf1e430635ab
        // o hashcode do java não é criptografia.
        // objetivo do hashcode é simples, o mesmo numero cai na mesma posição do Map

        return Objects.hash(min, max);
    }

    public ClassificacaoIMC getClassificacao() {
        return classificacao;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }
}
