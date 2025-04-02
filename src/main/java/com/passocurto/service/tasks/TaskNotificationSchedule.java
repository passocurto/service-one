package com.passocurto.service.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskNotificationSchedule {

    private final TaskService taskService;

    public TaskNotificationSchedule(TaskService notificationService) {
        this.taskService = notificationService;
    }

    @Scheduled(fixedRate = 360000 * 24)
    public void checkAndNotifyTasks() {
        this.taskService.sendNotificationForDueTasks();
    }

}
