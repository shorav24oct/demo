package com.example.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class AppError {
    private String errorCode;
    private String message;
    private HttpStatus httpStatus;

    public AppError(String string, String message, HttpStatus httpStatus) {
    this.errorCode = string;
    this.message = message;
    this.httpStatus = httpStatus;
    }
}
