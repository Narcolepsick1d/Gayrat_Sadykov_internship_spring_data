package ru.sadikov.dz.magafondz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ru.sadikov.dz.magafondz.Services.TaskEmployeeService;
import ru.sadikov.dz.magafondz.models.TaskEmployee;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskEmployeeService taskEmployeeService;
   //логика для task конироллера с thymeleaf


}
