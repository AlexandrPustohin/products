package com.example.products.exceptions;

import com.example.products.exceptions.productExceptions.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    ResponseEntity<ErrorDetails> productNotFoundException(ProductNotFoundException ex){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), "ProductNotFoundException");
        return ResponseEntity.ok(errorDetails);
    }
}
