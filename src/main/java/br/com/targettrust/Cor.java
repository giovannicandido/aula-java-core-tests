package br.com.targettrust;

public enum Cor {
    RED(InvertColor.GREEN),
    GREEN(InvertColor.BLUE),
    BLUE(InvertColor.RED);
    // Enum pode ter variaveis
    private final InvertColor inverso;
    // Pode ter construtor
    Cor(InvertColor inverso) {
        this.inverso = inverso;
    }

    public InvertColor getInverso() {
        return inverso;
    }
}
