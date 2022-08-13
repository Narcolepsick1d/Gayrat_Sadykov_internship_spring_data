package ru.sadikov.dz.magafondz.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



import java.time.LocalDateTime;



@Getter @Setter @NoArgsConstructor @ToString
public class TaskEmployee {
    int taskId;
    int user_created_task_id;
    int executor_id;
    String task_description;
    LocalDateTime date_created;

    public LocalDateTime getDate_created() {
        date_created = LocalDateTime.now();
        return date_created;
    }
}
