package ru.sadikov.dz.magafondz.EmployeeService;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.sadikov.dz.magafondz.models.Employee;
import ru.sadikov.dz.magafondz.models.Intern;

import java.util.List;

public interface IInterService extends JpaRepository<Intern,Long> {
    List<Intern> findAll();
}
