package fr.epf.projetjava.controllers;

import fr.epf.projetjava.models.Task;
import fr.epf.projetjava.persistence.TaskDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class TasksController {
    private final TaskDao taskDao;

    public TasksController(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @GetMapping("/tasks")
    public String getTasks( Model model) {

      //model.addAttribute("dataT", taskDao.findAll());
      List<Task> tachee = new ArrayList<Task>();

        //tachee.addAll(taskDao.findAll());

        for (Task t: taskDao.findAll()
             ) {
            System.out.println("seses"+t.getUser());
            tachee.add(t);
        }





        //System.out.println("seses"+tachee.toString());

        //System.out.println();*/
        return "tasks-user";
    }
}
