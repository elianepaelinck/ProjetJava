package fr.epf.projetjava.controllers;

import fr.epf.projetjava.models.User;
import fr.epf.projetjava.persistence.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String getUsers(Model model) {
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

    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/projet")
    public String projet(Model model) {
        return "projet";
    }
}
