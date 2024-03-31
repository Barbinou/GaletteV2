package allo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter
public class Galette {
    protected ArrayList<PartDeGalette> parts = new ArrayList<PartDeGalette>();
    protected int poidsGalette;

    public Galette(int poidsGalette) {
        this.poidsGalette = poidsGalette;
    }

    public void createGalette(){
        int limites = 0;
        while (limites < getPoidsGalette()){
            int poidsAleatoire = new Random().nextInt(251 - 150) + 150;
            this.parts.add(new PartDeGalette(poidsAleatoire, false));
            limites += poidsAleatoire;
        }
        this.parts.add(new PartDeGalette( limites - getPoidsGalette(), false));
        this.parts.get(new Random().nextInt(parts.size() - 1)).setFeve(true);
    }

    public void setPoidsGalette(int poids) {
        poidsGalette = poids;
        parts.clear();
        createGalette();
    }

    public boolean isEmpty() {
        return getParts().isEmpty();
    }
}
