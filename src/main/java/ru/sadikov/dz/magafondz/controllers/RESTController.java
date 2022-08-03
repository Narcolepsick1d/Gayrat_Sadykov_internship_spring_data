package ru.sadikov.dz.magafondz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sadikov.dz.magafondz.Services.EmployeeService;
import ru.sadikov.dz.magafondz.Services.InterService;
import ru.sadikov.dz.magafondz.Services.UsersService;
import ru.sadikov.dz.magafondz.models.Employee;
import ru.sadikov.dz.magafondz.models.Intern;
import ru.sadikov.dz.magafondz.models.Role;
import ru.sadikov.dz.magafondz.models.Users;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class RESTController {
    private final UsersService usersService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private InterService interService;

@Autowired
    public RESTController(UsersService usersService) {
        this.usersService = usersService;
    }
    @GetMapping("/users")
    public List<Users> getUsers(){
    return usersService.getAllUsers();
    }
//    @GetMapping("/users/admin")
//    public Set<Role> getAdmin( ){return usersService.getUserByRoleId(3);}

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
}
