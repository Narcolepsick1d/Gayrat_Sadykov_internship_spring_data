package ru.sadikov.dz.magafondz.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

@Document(collation = "EmployeeTask")
@Getter @Setter @NoArgsConstructor
public class TaskEmployee {
    @Id
    private int taskId;

    private int user_created_task_id;
    private int executor_id;
    private String task_description;
    private Date date_created;

    public TaskEmployee(int user_created_task_id, int executor_id, String task_description, Date date_created) {
        this.user_created_task_id = user_created_task_id;
        this.executor_id = executor_id;
        this.task_description = task_description;
        this.date_created = date_created;
    }
}
