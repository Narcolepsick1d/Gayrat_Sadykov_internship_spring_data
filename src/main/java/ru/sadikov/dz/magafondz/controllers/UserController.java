package ru.sadikov.dz.magafondz.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sadikov.dz.magafondz.Reprository.IUsersRepository;
import ru.sadikov.dz.magafondz.Reprository.RoleRepository;
import ru.sadikov.dz.magafondz.models.Role;
import ru.sadikov.dz.magafondz.models.Users;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@Controller
@RequestMapping("/userslist")
public class UserController {
    @Autowired
    private IUsersRepository iUsersRepository;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/users")
    public String showUserList(Model model){
        List<Users> usersList = iUsersRepository.findAll();
        model.addAttribute("listUsers",usersList);
        return "userslist/users";
    }
@GetMapping("/users/new")
    public String showCreateNewUserForm(Model model){
        List<Role>roleList=roleRepository.findAll();
        model.addAttribute("listRoles",roleList);
        model.addAttribute("user",new Users());
        return "userslist/user_form";
}
@PostMapping("/users/save")
    public String saveUser(Users users){
        iUsersRepository.save(users);
        return "redirect:/userslist/users";

}
@GetMapping("/users/edit/{id}")
    public String showEditUserForm(@PathVariable("id") Integer id,Model model){
        Users users=iUsersRepository.findById(id).get();
        model.addAttribute("user",users);

        List<Role>roleList=roleRepository.findAll();
        model.addAttribute("listRoles",roleList);

        return "userslist/user_form";
}
    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        iUsersRepository.deleteById(id);
        return "redirect:/userslist/users";
    }

}
