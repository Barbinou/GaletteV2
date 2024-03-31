package allo;

public class GaletteFrangipane extends DecorateurDeGalette{
    private final int POIDS_SPECIFIQUE = 2000;
    public GaletteFrangipane(Galette galette) {
        super(galette);
        this.setPoidsGalette(POIDS_SPECIFIQUE);
    }
}
