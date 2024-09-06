package br.com.targettrust.orientacaoobjeto;

public interface Audio {
    default void inicializar() {
        System.out.println("--------- Inicializando audio default --------");
    }
    // Para simplificar vamos trabalhar com texto, mas no brinquedo o play receberia um audio byte[]
    void play(String audio);
}
