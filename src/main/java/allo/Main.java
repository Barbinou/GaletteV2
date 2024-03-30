package allo;

public class Main {
    public static void main(String[] args) {
        Concours concours = new Concours(10, 3);

        Supporteur supporteur1 = new Supporteur("Jean Bodin");
        Supporteur supporteur2 = new Supporteur("Dis Merci !!!");
        concours.ajouterObservateur(supporteur1);
        concours.ajouterObservateur(supporteur2);

        concours.createConcours();
        System.out.println(concours.concourir());
    }
}