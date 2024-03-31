package allo;

public class GalettePistache extends DecorateurDeGalette{
    private final int POIDS_SPECIFIQUE = 2500;
    public GalettePistache(Galette galette) {
        super(galette);
        this.setPoidsGalette(POIDS_SPECIFIQUE);
    }
}
