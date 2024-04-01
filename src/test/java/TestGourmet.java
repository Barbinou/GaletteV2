import allo.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestGourmet {

    @Test
    public void testFeve() {
        MangeurDeGalettes mangeurDeGalettes = new MangeurDeGalettes(500, new StrategieGourmet());
        Galette galetteBase = new GaletteBase(500);
        Galette galetteFrangipane = new GaletteFrangipane(galetteBase);
        galetteFrangipane.createGalette();
        PartDeGalette part = galetteFrangipane.getParts().get(0);
        part.setFeve(true);
        mangeurDeGalettes.manger(part);
        assert mangeurDeGalettes.isFeve();
    }

    @Test
    public void testRechercheDePart() {
        MangeurDeGalettes gourmet = new MangeurDeGalettes(500, new StrategieGourmet());
        Galette galetteBase = new GaletteBase(500);
        Galette galetteFrangipane = new GaletteFrangipane(galetteBase);
        galetteFrangipane.createGalette();
        PartDeGalette partATrouver = galetteFrangipane.getParts().get(0);
        partATrouver.setPoids(0);
        PartDeGalette part = gourmet.rechercheDeParts(List.of(galetteFrangipane));
        assertEquals(partATrouver, part);
    }
}
