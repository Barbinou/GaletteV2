package allo;

public class GaletteChiante extends DecorateurDeGalette{
    private final int POIDS_SPECIFIQUE = 1500;
    public GaletteChiante(Galette galette) {
        super(galette);
        this.setPoidsGalette(POIDS_SPECIFIQUE);
    }
}
