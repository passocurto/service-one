package com.passocurto.service.tasks;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private final TasksRepository tasksRepository;

    public TasksController(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }
    // Define your endpoints here, e.g., GET, POST, PUT, DELETE

    @PostMapping
    public ResponseEntity<TasksEntity> createTask(@RequestBody TaskRequest taskRequest) {
        TasksEntity taskEntity = new TasksEntity(taskRequest);
        return ResponseEntity.ok(this.tasksRepository.save(taskEntity));
    }

}
