package com.passocurto.service.tasks;

import java.time.LocalDateTime;

public record TaskRequest(String title, String email, LocalDateTime dueDate, Boolean notified) {
    // This record is used to encapsulate the task request data
    // It contains three fields: title, description, and dueDate
    // The record automatically generates getters and a constructor for these fields
}
