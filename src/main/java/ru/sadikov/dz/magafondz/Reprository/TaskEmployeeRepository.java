package ru.sadikov.dz.magafondz.Reprository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.sadikov.dz.magafondz.models.TaskEmployee;

import java.util.List;

@Repository
public interface TaskEmployeeRepository extends MongoRepository<TaskEmployee,Integer> {
    public TaskEmployee getByTaskEmployeeId(int id);
    public TaskEmployee getByTaskEmployeeIdLike(int id);
}
