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
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class Controllermain {

    private final UserDao userDao;
    private final ProjectDao projectDao;
    private final TaskDao taskDao;

    public Controllermain(UserDao userDao, ProjectDao projectDao, TaskDao taskDao) {
        this.userDao = userDao;
        this.projectDao = projectDao;
        this.taskDao = taskDao;
    }

    //LOGIN\\
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user", userDao.findAll());
        model.addAttribute("login", new Login());
        return "login";
    }

    @PostMapping("/login")
    public String validLogin(Model model, Login login) {
        Iterable<User> all = userDao.findAll();
        boolean isUser = false;

        for (User user:all) {
            if(login.getUsername().equals(user.getFirstName()) && login.getPassword().equals(user.getPassword())){
                model.addAttribute("datauser", userDao.findAll());
                model.addAttribute("dataproj", projectDao.findAll());
                model.addAttribute("projet", new Project());
                return "index";
            }
        }
        return "login";
    }

    //INDEX\\
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("datauser", userDao.findAll());
        model.addAttribute("dataproj", projectDao.findAll());
        model.addAttribute("projet", new Project());
        return "index";
    }

    //ADD PROJECT\\
    @PostMapping("/index")
    public String addProject(Project project, Model model) {
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
    @GetMapping("/projet/{id}")
    public String projet(@PathVariable("id") int itemId, Model model) {
        model.addAttribute("datauser", userDao.findAll());
        Project project = projectDao.findById(itemId).get();
        model.addAttribute("projet",project);
        model.addAttribute("task", new Task());
        return "projet";
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

    //ADD TASK IN PROJECT\\
    @PostMapping("/projet/{id}")
    public String addTask(@PathVariable("id") int projectId, Task task, Model model){
        Project project = projectDao.findById(projectId).get();
        project.addTask(taskDao.save(task));
        projectDao.save(project);
        return "redirect:/projet/{id}";
    }
}
