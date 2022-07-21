package ru.sadikov.dz.magafondz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import ru.sadikov.dz.magafondz.EmployeeService.IEmployeeService;
import ru.sadikov.dz.magafondz.EmployeeService.IInterService;
import ru.sadikov.dz.magafondz.models.Employee;
import ru.sadikov.dz.magafondz.models.Intern;

import java.util.List;
@CrossOrigin(origins = "http://localhost:8080")
@Controller
public class InternController {
    @Autowired
    IInterService iInterService;

    @GetMapping("/interlist")
    public String findCities(Model model) {

        var inter = (List<Intern>) iInterService.findAll();

        model.addAttribute("inter", inter);

        return "interlist";
    }
}
