package com.example.tasks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.tasks.Task;
import com.example.tasks.TaskController;
import com.example.tasks.TaskRepository;

@SpringBootTest
class TasksApplicationTests {
    @Autowired
    private TaskRepository taskRepository;

    @Test
    void contextLoads() {
        Task task = new Task(1L, "dsf", true);
        taskRepository.save(task);
    }

}
