package ru.sadikov.dz.magafondz.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sadikov.dz.magafondz.Services.UsersService;

import ru.sadikov.dz.magafondz.models.Users;


import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@Controller
@RequestMapping("/userslist")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @GetMapping("")
    public String viewHomePage(Model model){
        return findPaginated(1,"email","asc",model);
    }
    @GetMapping("/showNewUsersForm")
    public String showNewUsersForm(Model model){
        Users users = new Users();
        model.addAttribute("users",users);
        return "userslist/new_user";
    }
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("users") Users user){
        usersService.saveUsers(user);
        return "redirect:/userslist";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") Integer id, Model model) {


        Users users = usersService.getUsersById(id);


        model.addAttribute("users", users);
        return "userslist/update_user";
    }
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable (value = "id") Integer id){
        this.usersService.deleteUsersById(id);
        return "redirect:/userslist";
    }






    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Users> page = usersService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Users> usersList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listUsers", usersList);
        return "userslist/index";
    }

}
