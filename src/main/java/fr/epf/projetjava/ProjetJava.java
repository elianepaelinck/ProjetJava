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

    //USERS
    User loic = new User(null, "Loic", "Ortola","password");
    User ambroise = new User(null, "Ambroise", "Soullier","password");
    User harry = new User(null, "Harry", "Covert","password");
    User luc = new User(null, "Luc", "Lebert","password");
    User val = new User(null, "Valentin", "Mazhar","password");

    userDao.save(loic);
    userDao.save(ambroise);
    userDao.save(harry);
    userDao.save(luc);
    userDao.save(val);


    //LISTS USERS
     List<User> listeUser1 = new ArrayList();
     listeUser1.add(luc);
     listeUser1.add(val);
     listeUser1.add(loic);
     listeUser1.add(ambroise);
     listeUser1.add(harry);

     List<User> listeUser2 = new ArrayList();
     listeUser2.add(luc);
     listeUser2.add(val);

     List<User> listeUser3 = new ArrayList<>();
     listeUser3.add(ambroise);
     listeUser3.add(loic);
     listeUser3.add(harry);

     //TASKS
    Task tache1 = new Task(null, "Faire le ménage", "Fait", "Cuisine et salon", listeUser2);
    Task tache2 = new Task(null,  "Ranger sa chambre", "A faire", "Aspirateur et changer les draps", listeUser1);
    Task tache3 = new Task(null,"Page Login","Fait","Vérifier les connexion",listeUser2);
    Task tache4 = new Task(null,"Dashboard","A faire","Afficher projets",listeUser2);
    Task tache5 = new Task(null,"Préparer le cours","A faire","Faire le TP",listeUser3);

    taskDao.save(tache1);
    taskDao.save(tache2);
    taskDao.save(tache3);
    taskDao.save(tache4);
    taskDao.save(tache5);

    //LISTS TASKS
    List<Task> listeTask1 = new ArrayList();
    listeTask1.add(tache2);
    listeTask1.add(tache1);

    List<Task> listeTask2 = new ArrayList<>();
    listeTask2.add(tache3);
    listeTask2.add(tache4);

    List<Task> listeTask3 = new ArrayList<>();
    listeTask3.add(tache5);

    //PROJECTS
    Project project1 = new Project(null, "Projet personnel" , "img/showcase/project1.png", listeUser1, listeTask1);
    Project project2 = new Project(null, "Projet scolaire" , "img/showcase/project2.png", listeUser2, listeTask2);
    Project project3 = new Project(null, "Projet professionnel" , "img/showcase/project3.png", listeUser3, listeTask3);

    projectDao.save(project1);
    projectDao.save(project2);
    projectDao.save(project3);
  }
}