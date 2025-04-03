package com.passocurto.service.tasks;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Task")
@Table(name = "Task")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TasksEntity {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String email;
    private LocalDateTime duedate;
    private boolean notified;

    public TasksEntity(TaskRequest taskRequest) {
        this.title = taskRequest.title();
        this.email = taskRequest.email();
        this.duedate = taskRequest.dueDate();
        this.notified = taskRequest.notified() != null ? taskRequest.notified() : false;
    }

}
