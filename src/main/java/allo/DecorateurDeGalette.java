package allo;

public abstract class DecorateurDeGalette extends Galette {
    protected Galette galette;

    public DecorateurDeGalette(Galette galette) {
        super(galette.getPoidsGalette());
        this.galette = galette;
    }
}
