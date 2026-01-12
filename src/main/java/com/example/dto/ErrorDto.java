package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorDto {
    private String errorCode;
    private String message;
    private HttpStatus httpStatus;
}
