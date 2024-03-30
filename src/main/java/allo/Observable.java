package allo;

public interface Observable {
    void ajouterObservateur(Observateur o);
    void notifierObservateurs();
}