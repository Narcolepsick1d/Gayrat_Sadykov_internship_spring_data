/*
package ru.sadikov.dz.magafondz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.sadikov.dz.magafondz.Reprository.IUsersRepository;
import ru.sadikov.dz.magafondz.models.Users;

@Controller
public class HomeController {
    @Autowired
    private IUsersRepository iUsersRepository;
    @GetMapping("/home")
    public String home (Model model){
        model.addAttribute("users",iUsersRepository.findAll());
        return "/userhome";

    }
    @PostMapping("/users")
    public String saveUsers(Users users){
        iUsersRepository.save(users);
        return "redirect:/home";
    }
}
*/
