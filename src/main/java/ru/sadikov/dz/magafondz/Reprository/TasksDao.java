package ru.sadikov.dz.magafondz.Reprository;


import org.springframework.data.mongodb.repository.MongoRepository;
import ru.sadikov.dz.magafondz.models.Tasks;

public interface TasksDao extends MongoRepository<Tasks, Integer> {
    public Tasks getTasksByTaskId(int id);
    public Tasks getTasksByTaskIdLike(int id);
}
