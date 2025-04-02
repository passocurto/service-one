package com.passocurto.service.tasks;

public record NotificationRequest(String message, String title) {
    // This record is used to encapsulate the notification request data
    // It contains two fields: message and title
    // The record automatically generates getters and a constructor for these fields

}
