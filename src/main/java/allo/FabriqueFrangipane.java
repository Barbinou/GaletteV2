package allo;

public class FabriqueFrangipane extends Fabrique {
    @Override
    public GaletteFrangipane cookGalette() {
        return new GaletteFrangipane(2000);
    }
}
