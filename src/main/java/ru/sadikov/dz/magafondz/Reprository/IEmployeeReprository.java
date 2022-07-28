package ru.sadikov.dz.magafondz.Reprository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.sadikov.dz.magafondz.models.Employee;

import java.util.List;
import java.util.Optional;


public interface IEmployeeReprository extends JpaRepository<Employee,Integer > {


}

