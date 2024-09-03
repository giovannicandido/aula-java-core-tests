package br.com.targettrust.model.concesionaria;

import br.com.targettrust.model.Cliente;
import br.com.targettrust.model.Veiculo;

public class Concesionaria {
    public Veiculo veiculo;

    public void alugar(Cliente cliente) {
        Veiculo veiculo = new Veiculo("HDU-0000");
        // veiculo.format();
    }
}
