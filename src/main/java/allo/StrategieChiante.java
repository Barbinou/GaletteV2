package allo;

import java.util.List;
import java.util.stream.Collectors;

public class StrategieChiante implements Stratego {

    @Override
    public PartDeGalette rechercheDeParts(List<Galette> liste) {
        return trouverGalette(liste).get(0).getParts().get(0);
    }

    public List<Galette> trouverGalette (List<Galette> liste) {
        List<Galette> galettesChiante = liste.stream()
                .filter(g -> g instanceof GaletteChiante)
                .collect(Collectors.toList());

        if (galettesChiante.isEmpty())
            return liste;

        return galettesChiante;
    }
}
