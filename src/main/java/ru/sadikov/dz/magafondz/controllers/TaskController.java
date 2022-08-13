package ru.sadikov.dz.magafondz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ru.sadikov.dz.magafondz.Services.TaskEmployeeService;
import ru.sadikov.dz.magafondz.models.TaskEmployee;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/taskEmployee")
public class TaskController {
    @Autowired
    private TaskEmployeeService taskEmployeeService;
   //логика для task контроллера с thymeleaf
    @RequestMapping("/add")
    public String addTaskEmp(){return "taskEmployee/add";}
    @PostMapping("/taskEmployee")
    public String saveTaskEmp(TaskEmployee taskEmployee){
        System.out.println("Dannie"+taskEmployee);
        taskEmployeeService.saveTaskEmp(taskEmployee);
        return "redirect:/taskEmployee/getAllTaskEmp";
    }
    @RequestMapping("/taskEmployee")
    public  String findallTaskEmp(Model model){
        List ls = taskEmployeeService.getAllTasksEmp();
        model.addAttribute("taskEmp",ls);
        return "taskEmployee/show";
    }
    @GetMapping("/oneTaskEmp/{id}")
    public String findOne(@PathVariable ("id")int id,Model model){
        TaskEmployee taskEmployee = taskEmployeeService.findOne(id);
        System.out.println("Zapros"+taskEmployee);
        model.addAttribute("taskEmp",taskEmployee);
        return "taskEmployee/edit";
    }
    @RequestMapping("/removeTaskEmp")
    public String removeTaskEmp(int id){
        System.out.println("udalit'"+id);
        taskEmployeeService.removeTaskEmpById(id);
        return "redirect:/taskEmployee/getAllTaskEmp";
    }
    @PutMapping("/updateTaskEmp/{id}")
    public String updateTaskEmp(TaskEmployee taskEmployee){
        taskEmployeeService.updateTaskEmp(taskEmployee);
        return "redirect:/taskEmployee/getAllTaskEmp";
    }














}
