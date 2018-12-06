package com.project.usermanagement.responseentity;

import org.springframework.http.HttpStatus;

public class UserResponseEntity {
    public String message;
    public HttpStatus statusCode;

    public UserResponseEntity(String message, HttpStatus statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }
}
