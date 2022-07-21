package ru.sadikov.dz.magafondz.EmployeeService;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.sadikov.dz.magafondz.models.Employee;

import java.util.List;



    public interface IEmployeeService extends JpaRepository<Employee,Long> {

        List<Employee> findAll();
    }

