package com.passocurto.service.tasks;

import java.time.LocalDateTime;
import java.util.List;

public class TaskService {
    // This class is responsible for managing tasks
    // It contains methods to create, update, delete, and retrieve tasks
    // It also interacts with the TasksRepository to perform database operations

    private final TasksRepository tasksRepository;
    private final NotificationClient notificationClient;

    public TaskService(TasksRepository tasksRepository, NotificationClient notificationClient) {
        this.tasksRepository = tasksRepository;
        this.notificationClient = notificationClient;
    }

    public void sendNotificationForDueTasks() {
        LocalDateTime deadLine = LocalDateTime.now().plusDays(1); // Example: 1 day from now
        List<TasksEntity> dueTasks = tasksRepository.findTaskDueWithinDeadLine(deadLine); // Assuming this method exists
                                                                                          // in the repository
        for (TasksEntity task : dueTasks) {
            NotificationRequest request = new NotificationRequest("Task Due", "Task " + task.getTitle() + " is due!");
            notificationClient.sendNotification(request);
            task.setNotified(true);

        }
    }

}
