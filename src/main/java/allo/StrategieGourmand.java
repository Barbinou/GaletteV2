package allo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StrategieGourmand implements Stratego{
    @Override
    public PartDeGalette rechercheDeParts(List<Galette> liste) {
        PartDeGalette galettePistache = findMaxGalettePistache(liste);
        if (galettePistache != null) return galettePistache;
        return getGrossePart(liste);
    }


    //Le gourmet mange d abord les  parts de pistaches les + grosse puis les part les plus grosses dans toutes les
    // galetttes dispo

    //En gros on cherche toutes les galettes pistaches, puis dans toutes ces galettes on trie les part
    //et on commence par la plus grosse

    //Et quand il n'y a plus de pistache, il mange les part les plus grosse dans la totalité des galettes

    private PartDeGalette findMaxGalettePistache(List<Galette> liste) {
        List<Galette> pistache = liste.stream()
                .filter(g -> g instanceof GalettePistache)
                .collect(Collectors.toList());

        if (pistache.isEmpty()) return null;

        return getGrossePart(pistache);
    }

    private PartDeGalette getGrossePart(List<Galette> liste){
        PartDeGalette laplusGrosse = null;
        for (Galette galette : liste){
            PartDeGalette grossepart = galette.getParts().stream().
                    max((Comparator.comparingDouble(PartDeGalette::getPoids))).
                    orElse(null);

            if (laplusGrosse == null || grossepart.getPoids() < laplusGrosse.getPoids()){
                laplusGrosse = grossepart;
            }
        }
        return laplusGrosse;
    }
}
