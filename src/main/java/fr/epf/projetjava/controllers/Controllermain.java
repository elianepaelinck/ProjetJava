package fr.epf.projetjava.controllers;

import fr.epf.projetjava.models.Project;
import fr.epf.projetjava.persistence.ProjectDao;
import fr.epf.projetjava.persistence.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controllermain {

    private final UserDao userDao;
    private final ProjectDao projectDao;

    public Controllermain(UserDao userDao, ProjectDao projectDao) {
        this.userDao = userDao;
        this.projectDao = projectDao;
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("datauser", userDao.findAll());
        model.addAttribute("dataproj", projectDao.findAll());
        model.addAttribute("projet", new Project());
        return "index";
    }
/*
    @GetMapping("/projet")
    public String projet(Model model) {
        model.addAttribute("datauser", userDao.findAll());
        return "projet";
    }*/

    @GetMapping(value = "index/{id}")
    public String show(@PathVariable("id") int itemId, Model model) {
        Project project = projectDao.findById(itemId).get();
        model.addAttribute("projet",project);
        return "projet";
    }

    @PostMapping("/index")
    public String addProject(Project project, Model model) {
        projectDao.save(project);
        return "redirect:/index";
    }
}
