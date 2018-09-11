package fr.epf.projetjava.models;

public class Task {

    private String nom;
    private String statut;
    private String echeance;
    private User user;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getEcheance() {
        return echeance;
    }

    public void setEcheance(String echeance) {
        this.echeance = echeance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Task(String nom, String statut, String echeance, User user) {
        this.nom = nom;
        this.statut = statut;
        this.echeance = echeance;
        this.user = user;
    }

    public Task() {
    }
}
