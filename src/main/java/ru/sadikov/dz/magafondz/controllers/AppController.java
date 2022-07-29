package ru.sadikov.dz.magafondz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.sadikov.dz.magafondz.Services.UserService;
import ru.sadikov.dz.magafondz.models.Role;
import ru.sadikov.dz.magafondz.models.Users;

import java.util.List;

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

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<Users> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model) {
        Users user = service.get(id);
        List<Role> listRoles = service.listRoles();
        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);
        return "user_form";
    }
    @GetMapping("/users/delete/{id}")
    public String editUser(@PathVariable("id") Integer id){
        service.deleteUsers(id);
        return "redirect:/users";
    }

    @PostMapping("/users/save")
    public String saveUser(Users user) {
        service.save(user);

        return "redirect:/users";
    }
}

