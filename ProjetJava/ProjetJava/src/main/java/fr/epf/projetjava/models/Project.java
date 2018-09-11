package fr.epf.projetjava.models;

import java.util.ArrayList;

public class Project {

    private String nom;
    private ArrayList<User> worker = new ArrayList<User>();
    private ArrayList<Task> projectTasks = new ArrayList<Task>();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<User> getWorker() {
        return worker;
    }

    public void setWorker(ArrayList<User> worker) {
        this.worker = worker;
    }

    public ArrayList<Task> getProjectTasks() {
        return projectTasks;
    }

    public void setProjectTasks(ArrayList<Task> projectTasks) {
        this.projectTasks = projectTasks;
    }

    public Project(String nom, ArrayList<User> worker, ArrayList<Task> projectTasks) {
        this.nom = nom;
        this.worker = worker;
        this.projectTasks = projectTasks;
    }

    public Project() {
    }

}
