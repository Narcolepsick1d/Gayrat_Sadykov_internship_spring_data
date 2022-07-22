package ru.sadikov.dz.magafondz.Reprository;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.sadikov.dz.magafondz.models.Employee;

import java.util.List;



    public interface IEmployeeReprository extends JpaRepository<Employee,Long> {

        List<Employee> findAll();
    }

