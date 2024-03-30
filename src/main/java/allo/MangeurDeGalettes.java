package allo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MangeurDeGalettes {
    private int poidsPeutMange, poidsMange;
    private boolean feve = false;
    @Setter
    private Stratego strategie;

    public MangeurDeGalettes(int poidsPeutMange, Stratego strategie) {
        this.poidsPeutMange = poidsPeutMange;
        this.poidsMange = 0;
        this.strategie = strategie;
    }
    public MangeurDeGalettes() {
        this.poidsPeutMange = 0;
        this.poidsMange = 0;
    }

    public void manger(PartDeGalette part){
        this.poidsMange += part.getPoids();
        this.feve = part.isFeve();
    }

    public PartDeGalette rechercheDeParts(List<Galette> galette) {
        return strategie.rechercheDeParts(galette);
    }
}
