package com.example.demo.exception;

import com.example.demo.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        ErrorResponse errorResponse= new ErrorResponse(
                productNotFoundException.getMessage(), LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
