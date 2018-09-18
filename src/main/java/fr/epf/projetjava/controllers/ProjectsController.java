package fr.epf.projetjava.controllers;

import fr.epf.projetjava.models.Project;
import fr.epf.projetjava.models.Task;
import fr.epf.projetjava.persistence.ProjectDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;;
import java.util.List;

@Controller
public class ProjectsController {
    private final ProjectDao projectDao;

    public ProjectsController(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @GetMapping("/project2")
    public String getProject( Model model) {
        model.addAttribute("data", projectDao.findAll());
        model.addAttribute("project", new Project());
        return "test_add_project";
    }

    @PostMapping("/project2")
    public String addProject( Project project, Model model) {
        projectDao.save(project);
        return ("redirect:/project");
    }



}