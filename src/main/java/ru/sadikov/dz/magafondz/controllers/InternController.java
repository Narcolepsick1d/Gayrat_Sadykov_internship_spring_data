package ru.sadikov.dz.magafondz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import ru.sadikov.dz.magafondz.Services.InterService;
import ru.sadikov.dz.magafondz.models.Intern;

import java.util.List;
@CrossOrigin(origins = "http://localhost:8080")
@Controller
@RequestMapping("/internlist")
public class InternController {
    @Autowired
    private InterService interService;


    @GetMapping("")
    public String viewHomePage(Model model) {
        return findPaginated(1, "name", "asc", model);
    }

    @GetMapping("/showNewInternForm")
    public String showNewInternForm(Model model) {

        Intern intern = new Intern();
        model.addAttribute("intern", intern);
        return "internlist/new_intern";
    }

    @PostMapping("/saveIntern")
    public String saveIntern(@ModelAttribute("intern") Intern intern) {

        interService.saveIntern(intern);
        return "redirect:/internlist";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") String name, Model model) {


        Intern intern = interService.getInternByName(name);


        model.addAttribute("intern", intern);
        return "internlist/update_intern";
    }

    @GetMapping("/deleteIntern/{id}")
    public String deleteIntern(@PathVariable (value = "id") String name) {


        this.interService.deleteInternByName(name);
        return "redirect:/internlist";
    }


    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Intern> page = interService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Intern> listIntern = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listIntern", listIntern);
        return "internlist/index";
    }
}
