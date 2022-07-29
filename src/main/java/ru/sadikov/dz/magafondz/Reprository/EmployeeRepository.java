package ru.sadikov.dz.magafondz.Reprository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sadikov.dz.magafondz.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
