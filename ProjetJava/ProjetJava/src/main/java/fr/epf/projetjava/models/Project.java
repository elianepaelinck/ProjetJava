package fr.epf.projetjava.models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity

public class Project {

    @Id @GeneratedValue
    private Integer id;
    private String nom;
   // private ArrayList<User> worker = new ArrayList<User>();
    //private ArrayList<Task> projectTasks = new ArrayList<Task>();


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

   /* public ArrayList<User> getWorker() {
        return worker;
    }

    public void setWorker(ArrayList<User> worker) {
        this.worker = worker;
    }
*/
    //public ArrayList<Task> getProjectTasks() {return projectTasks;}

    //public void setProjectTasks(ArrayList<Task> projectTasks) {this.projectTasks = projectTasks;}

    public Project(Integer id, String nom/*, ArrayList<User> worker*/ /*,ArrayList<Task> projectTasks*/) {
        this.id=id;
        this.nom = nom;
       // this.worker = worker;
        //this.projectTasks = projectTasks;
    }

    public Project() {
    }

}

