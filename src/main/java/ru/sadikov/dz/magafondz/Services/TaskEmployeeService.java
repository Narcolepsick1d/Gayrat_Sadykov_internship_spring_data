package ru.sadikov.dz.magafondz.Services;

import org.springframework.stereotype.Service;
import ru.sadikov.dz.magafondz.models.TaskEmployee;

import java.util.List;

@Service
public interface TaskEmployeeService {
    public TaskEmployee getByTaskEmpId(int taskid);
    public TaskEmployee getByTaskEmployeeidLike(int taskid);
    public void saveTaskEmp(TaskEmployee taskEmployee);
    public void removeTaskEmpById(int id);
    public void updateTaskEmp(TaskEmployee taskEmployee);
    public List<TaskEmployee> getAllTasksEmp();
    public TaskEmployee findOne(int id);



}
