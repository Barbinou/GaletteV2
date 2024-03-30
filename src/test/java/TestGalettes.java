import allo.Fabrique;
import allo.GaletteChiante;
import allo.GaletteFrangipane;
import allo.GaletteLegere;
import allo.GalettePistache;
import org.junit.Test;

public class TestGalettes {

    @Test
    public void testGalettePistache() {
        GalettePistache galettePistache = Fabrique.cookGalette(GalettePistache.class);
        assert galettePistache.getPoidsGalette() == 2500;
    }

    @Test
    public void testGaletteFrangipane() {
        GaletteFrangipane galetteFrangipane = Fabrique.cookGalette(GaletteFrangipane.class);
        assert galetteFrangipane.getPoidsGalette() == 2000;
    }

    @Test
    public void testGaletteLegere() {
        GaletteLegere galetteLegere = Fabrique.cookGalette(GaletteLegere.class);
        assert galetteLegere.getPoidsGalette() == 500;
    }

    @Test
    public void testGaletteChiante() {
        GaletteChiante galetteChiante = Fabrique.cookGalette(GaletteChiante.class);
        assert galetteChiante.getPoidsGalette() == 1500;
    }
}
