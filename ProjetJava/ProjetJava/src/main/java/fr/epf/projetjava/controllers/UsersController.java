package fr.epf.projetjava.controllers;

import fr.epf.projetjava.models.User;
import fr.epf.projetjava.persistence.TaskDao;
import fr.epf.projetjava.persistence.UserDao;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * TODO class details.
 *
 * @author Loïc Ortola on 10/09/2018
 */
@Controller

public class UsersController {

    private final UserDao userDao;


    public UsersController(UserDao userDao) {
        this.userDao = userDao;
    }


    /**
     * Ceci sera mappé sur l'URL '/users'.
     * C'est le routeur de Spring MVC qui va détecter et appeler directement cette méthode.
     * Il lui fournira un "modèle", auquel on pourra rajouter des attributs.
     * Ce modèle sera ensuite forwardé à une page web (dans resources/templates).
     * Le nom de la template est retourné par la fonction. Ici, elle appelle donc le template "users".
     *
     * @param model le modèle
     * @return
     */


    @GetMapping("/users")
    public String getUsers( Model model) {
        model.addAttribute("data", userDao.findAll());
        return "users-list";
    }

    @GetMapping("/user")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "add_member";
    }

    @PostMapping("/user")
    public String addUser(User user, Model model) {
        userDao.save(user);
        return "redirect:/users";
    }


}
