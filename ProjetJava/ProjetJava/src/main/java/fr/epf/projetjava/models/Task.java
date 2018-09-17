package fr.epf.projetjava.models;


import javax.persistence.*;
import java.util.List;


@Entity

public class Task {

    @Id
    @GeneratedValue
    private Integer id;
    private String nom;
    private Boolean statut;
    private String description;
    @ManyToMany
    private List<User> user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public Task(Integer id, String nom, Boolean statut, String description, List<User> user) {
        this.id = id;
        this.nom = nom;
        this.statut = statut;
        this.description = description;
        this.user = user;
    }

    public Task() {
    }
}


