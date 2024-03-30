package allo;

public class FabriquePistache extends Fabrique {
    @Override
    public GalettePistache cookGalette() {
        return new GalettePistache(2500);
    }
}
