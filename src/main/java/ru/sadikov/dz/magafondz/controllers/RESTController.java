package ru.sadikov.dz.magafondz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sadikov.dz.magafondz.Reprository.RoleRepository;
import ru.sadikov.dz.magafondz.Reprository.TasksService;
import ru.sadikov.dz.magafondz.Services.EmployeeService;
import ru.sadikov.dz.magafondz.Services.InterService;
import ru.sadikov.dz.magafondz.Services.UsersService;
import ru.sadikov.dz.magafondz.models.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class RESTController {
    private final UsersService usersService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private InterService interService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private TasksService tasksService;


@Autowired
    public RESTController(UsersService usersService) {
        this.usersService = usersService;
}
    @GetMapping("/users")
    public List<Users> getUsers(){
    return usersService.getAllUsers();
    }
    @GetMapping("/users/admin")
    public List<Users> getAdmin( ){
     Role role= roleRepository.findByName("ROLE_ADMIN");
return role.getUsers();}
    @GetMapping("/users/mentor")
    public List<Users> getMentor( ){
        Role role= roleRepository.findByName("ROLE_MENTOR");
        return role.getUsers();}
    @GetMapping("/users/manager")
    public List<Users> getManager( ){
        Role role= roleRepository.findByName("ROLE_MANAGER");
        return role.getUsers();}

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
    return employeeService.getAllEmployees();
    }
    @GetMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable (value = "id") Integer id){
        employeeService.deleteEmployeeById(id);

        return "Рабочий с таким id удален";
    }
    @GetMapping("/interns")
    public List<Intern> getInterns(){
    return interService.getAllInterns();
    }
    @GetMapping("/interns/{id}")
    public String deleteIntern(@PathVariable (value = "id") Integer id){
        interService.deleteInternById(id);

        return "Стажер с таким id удален";
    }
    @GetMapping("/users/{id}")
    public String deleteUser(@PathVariable (value = "id") Integer id){
        usersService.deleteUsersById(id);

        return "Юзер с таким id удален";
    }

    @GetMapping("/tasks")
    public List<Tasks> getTasks(){
    return tasksService.getAllTasks();
    }

}
