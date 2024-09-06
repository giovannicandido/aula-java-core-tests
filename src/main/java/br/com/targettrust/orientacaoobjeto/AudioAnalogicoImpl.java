package br.com.targettrust.orientacaoobjeto;

public class AudioAnalogicoImpl implements Audio {

    @Override
    public void play(String audio) {
        System.out.printf("Audio analogico tocando: %s", audio);
    }
}
