package allo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PartDeGalette {
    protected int poids;
    protected boolean feve;

    public PartDeGalette(int poids, boolean feve) {
        this.poids = poids;
        this.feve = feve;
    }

    public float getPoids() {
        return poids;
    }

    public boolean isFeve() {
        return feve;
    }

    public void setFeve(boolean feve) {
        this.feve = feve;
    }
}



