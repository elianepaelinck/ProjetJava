package fr.epf.projetjava.controllers;

import fr.epf.projetjava.models.Login;
import fr.epf.projetjava.models.Project;
import fr.epf.projetjava.models.Task;
import fr.epf.projetjava.models.User;
import fr.epf.projetjava.persistence.ProjectDao;
import fr.epf.projetjava.persistence.TaskDao;
import fr.epf.projetjava.persistence.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;


@Controller
public class Controllermain {

    private final UserDao userDao;
    private final ProjectDao projectDao;
    private final TaskDao taskDao;
    private int IDUser=0;
    private String messageError="";

    public Controllermain(UserDao userDao, ProjectDao projectDao, TaskDao taskDao) {
        this.userDao = userDao;
        this.projectDao = projectDao;
        this.taskDao = taskDao;
    }

    //LOGIN\\
    @GetMapping("/login")
    public String login(Model model){
        IDUser=0;
        model.addAttribute("user", userDao.findAll());
        model.addAttribute("login", new Login());
        model.addAttribute("messEr",messageError);
        return "login";
    }

    @PostMapping("/login")
    public String validLogin(Model model, Login login) {
        Iterable<User> all = userDao.findAll();
        boolean isUser = false;

        for (User user:all) {
            if(login.getUsername().equals(user.getFirstName()) && login.getPassword().equals(user.getPassword())){
               IDUser=user.getId();
               return "redirect:/index";
            }
        }
        messageError="Erreur de connection.";
        return "redirect:/login";
    }

    //INDEX\\
    @GetMapping("/index")
    public String index(Model model) {
        if(IDUser==0){
            return "redirect:/errorCo";
        }
        model.addAttribute("datauser", userDao.findAll());

        Iterable<Project> allproject = projectDao.findAll();
        List<Project> userprojet = new ArrayList<>();

        for (Project projet:allproject) {
            List<User> worker = projet.getWorker();
            for (User user:worker) {
                if(user.getId()==IDUser){
                    userprojet.add(projet);
                }
            }
        }

        model.addAttribute("dataproj", userprojet);
        model.addAttribute("projet", new Project());
        model.addAttribute("user",userDao.findById(IDUser).get());
        return "index";
    }

    //INSCRIPTION
    @GetMapping("/inscription")
    public String inscription(Model model){
        messageError="";
        User user = new User();
        user.setId(null);
        model.addAttribute("user", user );
        model.addAttribute("messEr", messageError);
        return "inscription";
    }

    @PostMapping("/inscription")
    public String newUser(Model model, User user){

        if(user.getLastName().equals("") || user.getFirstName().equals("") || user.getPassword().equals("")){
            messageError="Veuillez remplir tous les champs.";
            return "redirect:/inscription";
        }
        Iterable<User> users = userDao.findAll();

        for (User worker:users) {
            if(user.getFirstName().equals(worker.getFirstName())){
                messageError="Ce user existe déjà.";
                return "redirect:/inscription";
            }
        }

        userDao.save(user);
        return "redirect:/login";
    }

    //ADD PROJECT\\
    @PostMapping("/index")
    public String addProject(Project project, Model model) {
        List<User> workers = project.getWorker();
        for (User user:workers) {
            if(user.getId()==IDUser){
                projectDao.save(project);
                return "redirect:/index";
            }
        }
        workers.add(userDao.findById(IDUser).get());
        projectDao.save(project);
        return "redirect:/index";
    }

    //DELETE PROJECT\\
    @PostMapping("index/{id}")
    public String deleteProject(@PathVariable("id") int itemId, Model model) {
        Project project = projectDao.findById(itemId).get();
        projectDao.delete(project);
        return "redirect:/index";
    }

    //PROJECT\\
    @RequestMapping(value = "/projet/{id}", method = RequestMethod.GET)
    public String projet(@PathVariable("id") int itemId, Model model) {
        model.addAttribute("datauser", userDao.findAll());
        Project project = projectDao.findById(itemId).get();
        model.addAttribute("projet",project);
        model.addAttribute("task", new Task());
        return "projet";
    }

    //ADD TASK IN PROJECT\\
    @RequestMapping(value = "/projet/{id}", method = RequestMethod.POST)
    public String addTask(@PathVariable("id") int projectId, Task task, Model model){
        Project project = projectDao.findById(projectId).get();
        project.addTask(taskDao.save(task));
        projectDao.save(project);
        return "redirect:/projet/{id}";
    }

    //DELETE TASK IN PROJECT\\
    @PostMapping("projet/{id}/{ID}")
    public String deleteTask(@PathVariable("id") int projId, @PathVariable("ID") int taskId, Model model) {
        Project project = projectDao.findById(projId).get();
        Task task = taskDao.findById(taskId).get();
        project.suppTask(task);
        projectDao.save(project);
        return "redirect:/projet/{id}";
    }

    @GetMapping("/errorCo")
    public String errorCo(){
        return "/errorCo";
    }
}
