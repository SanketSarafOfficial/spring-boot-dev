package com.in28minutes.rest.webservices.springbootdevelopment.Exception;

import java.time.LocalDateTime;

// body of our own generic exception class
public class ErrorDetails {
    // This body will be used to create our own generic Exception format

    private LocalDateTime timeStamp;

    private String message;

    private String details;

    // generate the constructors , Getters
    public ErrorDetails(LocalDateTime timeStamp, String message, String details) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
