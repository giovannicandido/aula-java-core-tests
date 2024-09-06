package br.com.targettrust.orientacaoobjeto;

public class AudioDigitalImpl implements Audio{
    @Override
    public void inicializar() {
        System.out.println("Audio digital inicializado");
    }

    @Override
    public void play(String audio) {
        System.out.printf("Audio digital tocando: %s", audio);
    }
}
