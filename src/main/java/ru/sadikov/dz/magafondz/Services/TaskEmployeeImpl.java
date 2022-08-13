package ru.sadikov.dz.magafondz.Services;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.data.mongodb.core.query.Query;

import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


import ru.sadikov.dz.magafondz.Reprository.TaskEmployeeRepository;
import ru.sadikov.dz.magafondz.models.TaskEmployee;




@Service
public class TaskEmployeeImpl implements  TaskEmployeeService{
    @Resource
    private MongoTemplate mongoTemplate;
    @Resource
    TaskEmployeeRepository taskEmployeeRepository;


    @Override
    public TaskEmployee getByTaskEmpId(int taskid) {
        return taskEmployeeRepository.getTaskEmployeeByTaskId(taskid);
    }

    @Override
    public TaskEmployee getByTaskEmployeeidLike(int taskid) {
        return taskEmployeeRepository.getTaskEmployeeByTaskIdLike(taskid);
    }

    @Override
    public void saveTaskEmp(TaskEmployee taskEmployee) {
        taskEmployee.getDate_created();
        taskEmployeeRepository.save(taskEmployee);

    }

    @Override
    public void removeTaskEmpById(int id) {
        Query q = new Query(new Criteria("taskId").is(id));
        mongoTemplate.remove(q,TaskEmployee.class);
    }

    @Override
    public void updateTaskEmp(TaskEmployee taskEmployee) {
        Query q = new Query(new Criteria("taskId").is(taskEmployee.getTaskId()));
        Update update = new Update();
        update.set("taskId",taskEmployee.getTaskId());
        update.set("user_created_task_id",taskEmployee.getUser_created_task_id());
        update.set("executor_id",taskEmployee.getExecutor_id());
        update.set("task_description",taskEmployee.getDate_created());
        update.set("date_created",taskEmployee.getDate_created());
    }

    @Override
    public List<TaskEmployee> getAllTasksEmp() {
        return taskEmployeeRepository.findAll();
    }

    @Override
    public TaskEmployee findOne(int id) {
        Query q = new Query(new Criteria("taskId").is(id));
        return mongoTemplate.findOne(q,TaskEmployee.class);
    }
}
