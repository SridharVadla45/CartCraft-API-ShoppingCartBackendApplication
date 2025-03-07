package com.sridhar.dev.shopping_cart.exception;

import com.sridhar.dev.shopping_cart.dto.ErrorResponseDto;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(404).body(new ErrorResponseDto(ex.getMessage(), "404", OffsetDateTime.now()));
    }
}
