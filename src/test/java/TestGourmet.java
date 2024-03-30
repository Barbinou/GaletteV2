import allo.Galette;
import allo.GaletteFrangipane;
import allo.PartDeGalette;
import allo.MangeurDeGalettes;
import allo.StrategieGourmet;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestGourmet {

    @Test
    public void testFeve() {
        MangeurDeGalettes mangeurDeGalettes = new MangeurDeGalettes(500, new StrategieGourmet());
        Galette galette = new GaletteFrangipane(2000);
        galette.createGalette();
        PartDeGalette part = galette.getParts().get(0);
        part.setFeve(true);
        mangeurDeGalettes.manger(part);
        assert mangeurDeGalettes.isFeve();
    }

    @Test
    public void testRechercheDePart() {
        MangeurDeGalettes gourmet = new MangeurDeGalettes(500, new StrategieGourmet());
        Galette galette = new GaletteFrangipane(2000);
        galette.createGalette();
        PartDeGalette partATrouver = galette.getParts().get(0);
        partATrouver.setPoids(0);
        PartDeGalette part = gourmet.rechercheDeParts(List.of(galette));
        assertEquals(partATrouver, part);
    }
}
