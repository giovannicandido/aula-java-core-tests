package br.com.targettrust.orientacaoobjeto;

import java.util.Map;
import java.util.Optional;

public class Cachorro implements Animal {
    private final Audio audio;

    private Map<TipoSom, String> tipoSomMap = Map.of(
            TipoSom.CARINHO, "au hehehe",
            TipoSom.FOME, "au com fome",
            TipoSom.BRINCAR, "au au"
    );

    public Cachorro(Audio audio) {
        this.audio = audio;
    }
    @Override
    public void fazerSom(TipoSom tipoSom) {
        String audioFile = Optional.ofNullable(tipoSomMap.get(tipoSom))
                .map(somOriginal -> "efeito -> " + somOriginal + " <- efeito") // efeito adicionado
                .orElse("");
        audio.play(audioFile);
    }
}
