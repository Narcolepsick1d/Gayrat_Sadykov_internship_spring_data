package ru.sadikov.dz.magafondz.Reprository;



import ru.sadikov.dz.magafondz.models.Tasks;

import java.util.List;

public interface TasksService {
    public Tasks getByTasksid(int id);
    public Tasks getByTasksidLike(int id);
    public void saveTasks(Tasks tasks);
    public void removeTasksByTasksid(int id);
    public void updateTasks(Tasks tasks);
    public List<Tasks> getAllTasks();
    public Tasks findOne(int id);
}
