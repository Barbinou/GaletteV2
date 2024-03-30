package allo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StrategieGourmet implements Stratego{
    @Override
    public PartDeGalette rechercheDeParts(List<Galette> liste) {
        List <Galette> frangipanes = findFrangipaneListe(liste);
        if (!frangipanes.isEmpty()){
            return getPetitePart(frangipanes);
        }
        else {
            return getPetitePart(liste);
        }
    }

    private List <Galette> findFrangipaneListe(List<Galette> liste){
        return liste.stream()
                .filter(galette -> galette instanceof GaletteFrangipane)
                .collect(Collectors.toList());
    }

    private PartDeGalette getPetitePart(List<Galette> liste){
        PartDeGalette laplusGrosse = null;
        for (Galette galette : liste){
            PartDeGalette grossepart = galette.getParts().stream().
                    min((Comparator.comparingDouble(PartDeGalette::getPoids))).
                    orElse(null);

            if (laplusGrosse == null || grossepart.getPoids() < laplusGrosse.getPoids()){
                laplusGrosse = grossepart;
            }
        }
        return laplusGrosse;
    }
}
