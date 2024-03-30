package allo;

public class FabriqueLegere extends Fabrique {
    @Override
    public GaletteLegere cookGalette() {
        return new GaletteLegere(500);
    }
}
