package com.example.products.exceptions;

import com.example.products.exceptions.organizationException.OrganizationNotFoundException;
import com.example.products.exceptions.productExceptions.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    ResponseEntity<ErrorDetails> productNotFoundException(ProductNotFoundException ex){
        return errorDetailsResponseEntity(ex);
    }

    @ExceptionHandler(OrganizationNotFoundException.class)
    ResponseEntity<ErrorDetails> organizationNotFoundException(OrganizationNotFoundException ex){
        return errorDetailsResponseEntity(ex);
    }

    private ResponseEntity<ErrorDetails> errorDetailsResponseEntity (Exception ex){
        return ResponseEntity.ok(new ErrorDetails(new Date(), ex.getMessage(), ex.getClass().getName()));
    }
}
