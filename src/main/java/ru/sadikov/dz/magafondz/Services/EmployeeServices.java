package ru.sadikov.dz.magafondz.Services;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sadikov.dz.magafondz.Reprository.IEmployeeReprository;
import ru.sadikov.dz.magafondz.models.Employee;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeeServices  {
    private final IEmployeeReprository iEmployeeReprository;

    public EmployeeServices(IEmployeeReprository iEmployeeReprository) {
        this.iEmployeeReprository = iEmployeeReprository;
    }
    public List<Employee> findAll() {
        return iEmployeeReprository.findAll();
    }
}
