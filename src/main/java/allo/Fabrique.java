package allo;

public abstract class Fabrique {

    public abstract Galette cookGalette();

    @SuppressWarnings("unchecked")
    public static  <T> T cookGalette(Class<T> galetteOf) {
        if (galetteOf == GalettePistache.class) return (T) new FabriquePistache().cookGalette();
        if (galetteOf == GaletteFrangipane.class) return (T) new FabriqueFrangipane().cookGalette();
        if (galetteOf == GaletteLegere.class) return (T) new FabriqueLegere().cookGalette();
        if (galetteOf == GaletteChiante.class) return (T) new FabriqueChiante().cookGalette();

        throw new IllegalArgumentException("Galette inconnue");
    }
}