package com.passocurto.service.tasks;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends JpaRepository<TasksEntity, Long> {
    // Custom query methods can be defined here if needed

    @Query("SELECT t FROM TasksEntity t WHERE t.dueDate <= :deadline AND t.notified = false")
    List<TasksEntity> findTaskDueWithinDeadLine(LocalDateTime deadline);

}
