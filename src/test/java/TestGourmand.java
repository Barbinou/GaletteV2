import allo.Galette;
import allo.GaletteFrangipane;
import allo.PartDeGalette;
import allo.MangeurDeGalettes;
import allo.StrategieGourmand;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestGourmand {
    @Test
    public void testFeve() {
        // manger part avec feve
        MangeurDeGalettes mangeurDeGalettes = new MangeurDeGalettes(2000, new StrategieGourmand());
        Galette galette = new GaletteFrangipane(2000);
        galette.createGalette();
        PartDeGalette part = galette.getParts().get(0);
        part.setFeve(true);
        mangeurDeGalettes.manger(part);

        assert mangeurDeGalettes.isFeve();
    }

    @Test
    public void testRechercheDeParts() {
        MangeurDeGalettes gourmand = new MangeurDeGalettes(2000, new StrategieGourmand());
        Galette galette = new GaletteFrangipane(2000);
        galette.createGalette();
        PartDeGalette partATrouver = galette.getParts().get(0);
        partATrouver.setPoids(1000);
        PartDeGalette part = gourmand.rechercheDeParts(List.of(galette));
        assertEquals(partATrouver, part);
    }
}

