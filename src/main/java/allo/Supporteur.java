package allo;

public class Supporteur implements Observateur{
    private String nom;

    public Supporteur(String nom) {
        this.nom = nom;
    }

    @Override
    public void applaudit() {
        System.out.println("Le supporteur " + nom + " applaudit!");
    }
}
