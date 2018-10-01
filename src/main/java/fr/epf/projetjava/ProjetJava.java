package fr.epf.projetjava;

import fr.epf.projetjava.models.Project;
import fr.epf.projetjava.models.Task;
import fr.epf.projetjava.models.User;
import fr.epf.projetjava.persistence.ProjectDao;
import fr.epf.projetjava.persistence.TaskDao;
import fr.epf.projetjava.persistence.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
public class ProjetJava {

  @Autowired
  private UserDao userDao;
  @Autowired
  private ProjectDao projectDao;
  @Autowired
  private TaskDao taskDao;


  public static void main(String[] args) {
    // Point d'entrée de l'application.
    // On dit à Spring de s'initialiser
    // Il va aller "regarder" nos classes et détecter les annotations des singletons
    // (@Controller, @Repository, @Component, @Service, etc...)
    // Ensuite, il va construire l'arbre de dépendances et le résoudre en injectant les données dans les bonnes classes

    SpringApplication.run(ProjetJava.class);

  }

  /**
   * On appelle cette méthode lorsque Spring a terminé son initialisation.
   * Ici, on va réinitialiser la DB et insérer 3 entrées.
   */
  @PostConstruct
  public void init() {
    /*userDao.deleteAll();
    taskDao.deleteAll();
    projectDao.deleteAll();

    userDao.save(new User(null, "Loic", "Ortola","password"));
    userDao.save(new User(null, "Ambroise", "Soullier","password"));
    userDao.save(new User(null, "Harry", "Covert","password"));

    //utilisateurs test
    User luc = new User(null, "luc", "lebert","password");
    User val = new User(null, "val", "mazhar","password");
    userDao.save(luc);
    userDao.save(val);

    //liste utilisateurs test
     List<User> listeUser2 = new ArrayList();
     listeUser2.add(luc);
     listeUser2.add(val);
     List<User> listeUser1 = new ArrayList();
     listeUser1.add(luc);

    Task tache1 = new Task(null, "luchu ctg", false, "faire le menage", listeUser2);
    Task tache2 = new Task(null,  "val", true, "ranger sa chambre", listeUser1);
    taskDao.save(tache2);
    taskDao.save(tache1);
    List<Task> listeTask2 = new ArrayList();
    listeTask2.add(tache2);
    listeTask2.add(tache1);

    Project testProject = new Project(null, "new project" , listeUser2, listeTask2);
    Project testProject2 = new Project(null, "new project bis" , listeUser1, listeTask2);
    projectDao.save(testProject);
    projectDao.save(testProject2);*/
  }
}