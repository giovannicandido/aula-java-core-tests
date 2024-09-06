package br.com.targettrust.orientacaoobjeto;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Audio audio = new AudioAnalogicoImpl();
        audio.inicializar();

        Animal gato = new Gato(audio);
        gato.fazerSom(TipoSom.CARINHO);
        gato.fazerSom(TipoSom.FOME);
        gato.fazerSom(TipoSom.BRINCAR);

        Animal cachorro = new Cachorro(audio);
        System.out.println();
        System.out.println("---------------->>>>>>>>>>>>>> ");
        cachorro.fazerSom(TipoSom.CARINHO);
        cachorro.fazerSom(TipoSom.FOME);
        cachorro.fazerSom(TipoSom.BRINCAR);

        List.of("exemplo").stream().forEach(System.out::println);
    }
}
