package fr.epf.projetjava.controllers;

import fr.epf.projetjava.models.Project;
import fr.epf.projetjava.persistence.ProjectDao;
import fr.epf.projetjava.persistence.UserDao;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        return "index";
    }

    @GetMapping("/projet")
    public String projet(Model model) {
        model.addAttribute("datauser", userDao.findAll());
        return "projet";
    }

  /*  @RequestMapping(value = "offers/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable("id") int itemId, Model model) {
        Project project = projectDao.findById(itemId).get();
        projectDao.delete(project);
        return "redirect:/offers";
    }*/

    @RequestMapping(value = "index/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") int itemId, Model model) {
        Project project = projectDao.findById(itemId).get();
        model.addAttribute("projet",project);
        return "projet";
    }
}
