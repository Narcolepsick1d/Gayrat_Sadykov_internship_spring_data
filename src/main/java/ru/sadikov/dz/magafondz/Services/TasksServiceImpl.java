package ru.sadikov.dz.magafondz.Services;


import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import ru.sadikov.dz.magafondz.Reprository.TasksDao;
import ru.sadikov.dz.magafondz.Reprository.TasksService;
import ru.sadikov.dz.magafondz.models.Tasks;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class TasksServiceImpl implements TasksService {
    @Resource
    private MongoTemplate mongoTemplate;
    @Resource
    private TasksDao userDao;

    @Override
    public Tasks getByTasksid(int id) {
        return userDao.getTasksByTaskId(id);
    }

    @Override
    public Tasks getByTasksidLike(int id) {
        return userDao.getTasksByTaskIdLike(id);
    }

    @Override
    public void saveTasks(Tasks tasks) {
        tasks.setDate_created(LocalDateTime.now());
        userDao.save(tasks);
    }

    @Override
    public void removeTasksByTasksid(int id) {
        Query q=new Query(new Criteria("taskId").is(id));
        mongoTemplate.remove(q,Tasks.class);
    }

    @Override
    public void updateTasks(Tasks tasks) {
        Query q=new Query(new Criteria("taskId").is(tasks.getTaskId()));
        Update update=new Update();
        update.set("taskId", tasks.getTaskId());
        update.set("user_created_task_id", tasks.getUser_created_task_id());
        update.set("executor_id",tasks.getExecutor_id());

        mongoTemplate.updateMulti(q, update,Tasks.class);
    }

    @Override
    public List<Tasks> getAllTasks() {
        return userDao.findAll();
    }

    @Override
    public Tasks  findOne(int id) {
        Query q=new Query(new Criteria("taskId").is(id));
        return mongoTemplate.findOne(q,Tasks.class);
    }
}
