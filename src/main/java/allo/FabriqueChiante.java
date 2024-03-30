package allo;

public class FabriqueChiante extends Fabrique {
    @Override
    public GaletteChiante cookGalette() {
        return new GaletteChiante(1500);
    }
}
