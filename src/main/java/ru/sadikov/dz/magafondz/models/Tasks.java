package ru.sadikov.dz.magafondz.models;

import java.time.LocalDateTime;


public class Tasks {
    int taskId;
    int user_created_task_id;
    int executor_id;
    String task_description;
    LocalDateTime date_created;

    @Override
    public String toString() {
        return "User{" +
                "taskId=" + taskId +
                ", user_created_task_id=" + user_created_task_id +
                ", executor_id=" + executor_id +
                ", task_description='" + task_description + '\'' +
                ", date_created=" + date_created +
                '}';
    }

    public int getUser_created_task_id() {
        return user_created_task_id;
    }

    public void setUser_created_task_id(int user_created_task_id) {
        this.user_created_task_id = user_created_task_id;
    }

    public int getExecutor_id() {
        return executor_id;
    }

    public void setExecutor_id(int executor_id) {
        this.executor_id = executor_id;
    }

    public String getTask_description() {
        return task_description;
    }

    public void setTask_description(String task_description) {
        this.task_description = task_description;
    }

    public LocalDateTime getDate_created() {

        return date_created;
    }

    public void setDate_created(LocalDateTime date_created) {
        this.date_created = date_created;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }





}
