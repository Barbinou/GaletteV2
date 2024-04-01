package allo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Concours implements Observable{
    protected int nbMangeurs, nbGalette;
    protected ArrayList<MangeurDeGalettes> listeMangeurs = new ArrayList<>();
    private List<Observateur> observateurs = new ArrayList<>();
    protected ArrayList<Galette> galettes = new ArrayList<>();

    public Concours(int nbMangeurs, int nbGalette) {
        this.nbMangeurs = nbMangeurs;
        this.nbGalette = nbGalette;
    }

    @Override
    public void ajouterObservateur(Observateur o) {
        observateurs.add(o);
    }

    @Override
    public void notifierObservateurs() {
        for (Observateur o : observateurs) {
            o.applaudit();
        }
    }

    private static final Random random = new Random();

    public void createConcours(){
        for (int i = 0; i < getNbGalette(); i++) {
            Galette galette = new GaletteBase(500);
            switch (random.nextInt(4)) {
                case 0 -> galette = new GaletteChiante(galette);
                case 1 -> galette = new GalettePistache(galette);
                case 2 -> galette = new GaletteFrangipane(galette);
                case 3-> galette = new GaletteLegere(galette);
            }

            galette.createGalette();
            galette.getParts().get(random.nextInt(galette.getParts().size())).setFeve((true));
            getGalettes().add(galette);
        }

        for (int i = 0; i < getNbMangeurs(); i++) {
            switch (random.nextInt(3)) {
                case 0 -> getListeMangeurs().add(new MangeurDeGalettes(1000, new StrategieChiante()));
                case 1 -> getListeMangeurs().add(new MangeurDeGalettes(2000, new StrategieGourmand()));
                case 2 -> getListeMangeurs().add(new MangeurDeGalettes(500, new StrategieGourmet()));
            }
        }
    }

    public void nettoyerTable() {
        for (int i = 0; i < getGalettes().size(); i++) {
            if (getGalettes().get(i).isEmpty()){
                getGalettes().remove(i);
            }
        }
    }

    public void enleverLesPerdants(){
        for (int i = 0; i < getListeMangeurs().size(); i++) {
            if (getListeMangeurs().get(i).getPoidsMange() >= getListeMangeurs().get(i).getPoidsPeutMange()){
                getListeMangeurs().remove(i);
                notifierObservateurs();
            }
        }
    }

    public MangeurDeGalettes concourir() {
        while (!getListeMangeurs().isEmpty()) {
            for (int i = 0; i < getListeMangeurs().size(); i++) {
                getListeMangeurs().get(i).manger(getListeMangeurs().get(i).rechercheDeParts(getGalettes()));
                if (getListeMangeurs().get(i).isFeve()) {
                    return getListeMangeurs().get(i);
                }
                enleverLesPerdants();
                nettoyerTable();
            }
        }
        return null;
    }
}