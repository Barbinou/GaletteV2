import allo.*;
import org.junit.Test;

public class TestGalettes {

    @Test
    public void testGalettePistache() {
        Galette baseGalette = new Galette(500);
        Galette galettePistache = new GalettePistache(baseGalette);
        assert galettePistache.getPoidsGalette() == 2500 : "ca doit etre 2500";
    }

    @Test
    public void testGaletteFrangipane() {
        Galette baseGalette = new Galette(500);
        Galette galetteFrangipane = new GaletteFrangipane(baseGalette);
        assert galetteFrangipane.getPoidsGalette() == 2000 : "ca doit etre 2000";
    }

    @Test
    public void testGaletteLegere() {
        Galette baseGalette = new Galette(5000);
        Galette galetteLegere = new GaletteLegere(baseGalette);
        assert galetteLegere.getPoidsGalette() == 500 : "ca doit etre 500";
    }

    @Test
    public void testGaletteChiante() {
        Galette baseGalette = new Galette(500);
        Galette galetteChiante = new GaletteChiante(baseGalette);
        assert galetteChiante.getPoidsGalette() == 1500 : "ca doit etre 1500";
    }
}
