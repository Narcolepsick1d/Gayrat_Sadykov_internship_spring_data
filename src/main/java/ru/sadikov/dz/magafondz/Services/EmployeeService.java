package ru.sadikov.dz.magafondz.Services;


import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.sadikov.dz.magafondz.models.Employee;

import java.util.List;

@Service
public interface EmployeeService {
	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(Integer id);
	void deleteEmployeeById(Integer id);
	Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
