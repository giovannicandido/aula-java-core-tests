package br.com.targettrust.orientacaoobjeto;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Gato implements Animal {

    private final Audio audio;
    private Map<TipoSom, String> tipoSomMap = Map.of(
            TipoSom.CARINHO, "ronronronr",
            TipoSom.FOME, "miau com fome",
            TipoSom.BRINCAR, "miau miau"
    );

    public Gato(Audio audio) {
        this.audio = audio;
    }

    @Override
    public void fazerSom(TipoSom tipoSom) {
//        String audioFile = "";
//        if(TipoSom.CARINHO.equals(tipoSom)){
//            audioFile = "ronronronr";
//        }
//        else if(TipoSom.FOME.equals(tipoSom)){
//            audioFile = "miau com fome";
//        } else if(TipoSom.BRINCAR.equals(tipoSom)){
//            audioFile = "miau miau";
//        }
        String audioFile = Optional.ofNullable(tipoSomMap.get(tipoSom)).orElse("");
        audio.play(audioFile);
    }
}
