package fr.epf.projetjava.controllers;

import fr.epf.projetjava.models.Task;
import fr.epf.projetjava.persistence.TaskDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;;
import java.util.List;

@Controller
public class TasksController {
    private final TaskDao taskDao;

    public TasksController(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @GetMapping("/tasks")
    public String getTasks( Model model) {
        List<Task> tachee = new ArrayList<>();

            for (Task t: taskDao.findAll()) {
             tachee.add(t);
                }
        model.addAttribute("modell",tachee);

        return "tasks-list";
    }
}
