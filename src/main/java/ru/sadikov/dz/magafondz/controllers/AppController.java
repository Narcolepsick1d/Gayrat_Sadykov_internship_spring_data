package ru.sadikov.dz.magafondz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.sadikov.dz.magafondz.Services.UserService;
import ru.sadikov.dz.magafondz.models.Users;



@CrossOrigin(origins = "http://localhost:8080")
@Controller
public class AppController {

    @Autowired
    private UserService service;
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Users());

        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(Users user) {
        service.saveUserWithDefaultRole(user);

        return "register_success";
    }


}

