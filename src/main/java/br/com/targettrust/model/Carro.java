package br.com.targettrust.model;

public class Carro extends Veiculo {

    public Carro(String placa) {
        super(placa);
    }

    public void salvarInformacoe() {
        String format = format();
        System.out.println(format);
    }
}
