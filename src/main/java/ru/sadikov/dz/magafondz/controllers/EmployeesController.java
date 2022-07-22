package ru.sadikov.dz.magafondz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import ru.sadikov.dz.magafondz.Reprository.IEmployeeReprository;
import ru.sadikov.dz.magafondz.models.Employee;

import java.util.List;
@CrossOrigin(origins = "http://localhost:8080")
@Controller
public class EmployeesController {
    @Autowired
    IEmployeeReprository employeeService;

    @GetMapping("/employeelist")
    public String findCities(Model model) {

        var employees = (List<Employee>) employeeService.findAll();

        model.addAttribute("employee", employees);

        return "employeelist";
    }
}