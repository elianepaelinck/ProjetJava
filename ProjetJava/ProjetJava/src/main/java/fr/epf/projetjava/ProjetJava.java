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
  private ProjectDao projectDao;
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
    userDao.save(new User(null,"Loic", "Ortola"));
    userDao.save(new User(null, "Ambroise", "Soullier"));
    userDao.save(new User(null, "Harry", "Covert"));

    User luc = new User(null,"luc","lebert");
    User val = new User(null,"val","mazhar");

    ArrayList testU = new ArrayList();
    testU.add(luc);
    testU.add(val);

    ArrayList testT = new ArrayList();
    testT.add(new Task(null,"tache de luc",null,"ceci est ma tache", luc));

//    Project testProject = new Project (null,"new projet", testU, testT);

//    projectDao.deleteAll();
//    projectDao.save(testProject);

      taskDao.deleteAll();
      taskDao.save(new Task(null,"tache de luc",false,"ceci est ma tache", luc));

  }
}