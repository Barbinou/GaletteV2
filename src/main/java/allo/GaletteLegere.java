package allo;

public class GaletteLegere extends DecorateurDeGalette{
    private final int POIDS_SPECIFIQUE = 500;
    public GaletteLegere(Galette galette) {
        super(galette);
        this.setPoidsGalette(POIDS_SPECIFIQUE);
    }
}
