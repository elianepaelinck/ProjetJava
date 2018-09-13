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
    userDao.deleteAll();
    taskDao.deleteAll();
    projectDao.deleteAll();

    userDao.save(new User(null,"Loic", "Ortola"));
    userDao.save(new User(null, "Ambroise", "Soullier"));
    userDao.save(new User(null, "Harry", "Covert"));

    //utilisateurs test
    User luc = new User(null,"luc","lebert");
    User val = new User(null,"val","mazhar");
    userDao.save(luc);
    userDao.save(val);

    Task tache1 = new Task(null,"tache de luc",false,"faire le menage", luc);
    Task tache2 = new Task(null, "tache de val", true, "ranger sa chambre",val);
    taskDao.save(tache2);
    taskDao.save(tache1);

    //liste utilisateurs test
    ArrayList listeUser = new ArrayList();
    listeUser.add(luc);
    listeUser.add(val);

    //liste taches test
    ArrayList listeTask = new ArrayList();
    listeTask.add(tache1);

    Project testProject = new Project (null,"new projet", listeUser, listeTask);

    projectDao.save(testProject);

  }
}