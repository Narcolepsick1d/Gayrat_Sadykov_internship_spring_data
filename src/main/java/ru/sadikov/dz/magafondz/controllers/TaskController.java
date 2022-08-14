package ru.sadikov.dz.magafondz.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sadikov.dz.magafondz.Reprository.TasksService;
import ru.sadikov.dz.magafondz.models.Tasks;

import java.util.List;

@Controller
public class TaskController {
    @Autowired
    private TasksService userService;

    @RequestMapping("/add")
    public String addUser() {
        return "add";
    }



    @PostMapping("/user")
    public String saveUser(Tasks tasks) {
        System.out.println("Добавленные данные："+tasks);
        userService.saveTasks(tasks);
        return "redirect:/getAll";
    }


    @RequestMapping("/getAll")
    public String findallUser(Model model){
        List ls= userService.getAllTasks();
        model.addAttribute("users",ls);
        return "show";
    }



    @GetMapping("/user/{id}")
    public String findOne(@PathVariable("id") int id, Model model){
        Tasks user = userService.findOne(id);
        System.out.println("Запрошенные данные:"+user);
        model.addAttribute("user",user);
        return "edit";
    }

    @RequestMapping("/removeUserById")
    public String removeUserById(int id) {
        System.out.println("Номер, который нужно удалить："+id);
        userService.removeTasksByTasksid(id);
        return "redirect:/getAll";
    }

  

    @PutMapping("/user/{id}")
    public String updateUser(Tasks tasks) {
        userService.updateTasks(tasks);
        return "redirect:/getAll";
    }

}
