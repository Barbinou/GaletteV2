import allo.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestGourmand {
    @Test
    public void testFeve() {
        // manger part avec feve
        MangeurDeGalettes mangeurDeGalettes = new MangeurDeGalettes(2000, new StrategieGourmand());
        Galette galetteBase = new GaletteBase(500);
        Galette galetteFrangipane = new GaletteFrangipane(galetteBase);
        galetteFrangipane.createGalette();
        PartDeGalette part = galetteFrangipane.getParts().get(0);
        part.setFeve(true);
        mangeurDeGalettes.manger(part);

        assert mangeurDeGalettes.isFeve();
    }

    @Test
    public void testRechercheDeParts() {
        MangeurDeGalettes gourmand = new MangeurDeGalettes(2000, new StrategieGourmand());
        Galette galetteBase = new GaletteBase(500);
        Galette galetteFrangipane = new GaletteFrangipane(galetteBase);
        galetteFrangipane.createGalette();
        PartDeGalette partATrouver = galetteFrangipane.getParts().get(0);
        partATrouver.setPoids(1000);
        PartDeGalette part = gourmand.rechercheDeParts(List.of(galetteFrangipane));
        assertEquals(partATrouver, part);
    }
}

