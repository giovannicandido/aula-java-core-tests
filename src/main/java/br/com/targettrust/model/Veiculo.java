package br.com.targettrust.model;

import br.com.targettrust.Cor;

public class Veiculo {
    // para todo mundo é o public
    public String marca;
    public String modelo;
    public Cor cor;
    // somente para classe veiculo ou para o objeto veiculo
    private String placa;
    public TipoVeiculo tipoVeiculo;

    protected String format() {
        return """
                Marca: %s,
                Modelo: %s,
                Cor: %s,
                Placa: %s,
                TipoVeiculo: %s
                """;
    }

    public Veiculo(String placa) {
        setPlaca(placa);
    }

    // Frameworks assume que isso existe
    // Jackson transforma a class em JSON. Ele assume que tem get e set
    private void setPlaca(String placa) {
        if(placa.length() == 9) {
            this.placa = "A"+ placa;
        } else {
            this.placa = placa;
        }
    }

    public String getPlaca() {
        return this.placa;
    }

    public boolean validar() {
        return true;
    }
}
