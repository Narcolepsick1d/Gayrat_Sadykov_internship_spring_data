package ru.sadikov.dz.magafondz.Reprository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ru.sadikov.dz.magafondz.models.TaskEmployee;




public interface TaskEmployeeRepository extends MongoRepository<TaskEmployee,Integer> {
    public TaskEmployee getTaskEmployeeByTaskId(int id);
    public TaskEmployee getTaskEmployeeByTaskIdLike(int id);
}
