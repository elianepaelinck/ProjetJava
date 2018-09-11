package fr.epf.projetjava.models;

import java.util.ArrayList;

public class Project {

    private String nom;
    private ArrayList<User> worker = new ArrayList<User>();
    private ArrayList<Task> projectTasks = new ArrayList<Task>();
}
