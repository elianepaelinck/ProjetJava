package fr.epf.projetjava.models;

import fr.epf.projetjava.persistence.TaskDao;

import javax.persistence.*;
import java.util.List;

@Entity

public class Project {

    @Id @GeneratedValue
    private Integer id;
    private String nom;
    @ManyToMany
    private List<User> worker ;
    @ManyToMany
    private List<Task> TasksP ;


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

    public List<User> getWorker() {
        return worker;
    }

    public void setWorker(List<User> worker) {
        this.worker = worker;
    }

    public List<Task> getTasksP() {return TasksP;}

    public void setTasksP(List<Task> TasksP) {this.TasksP = TasksP;}

    public void addTask(Task task){
        TasksP.add(task);
    }
    public void suppTask(Task task){
        TasksP.remove(task);
    }

    public Project(Integer id, String nom, List<User> worker,List<Task> TasksP) {
        this.id=id;
        this.nom = nom;
        this.worker = worker;
        this.TasksP = TasksP;
    }

    public Project() {
    }

}

