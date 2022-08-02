package com.vti.rw41.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationError(MethodArgumentNotValidException exception) {
        Map<String, String> messages = exception.getBindingResult().getFieldErrors().stream().map(this::createFieldErrorMessage)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return responseErrorMessages(messages, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception exception) {
        exception.printStackTrace();
        return responseErrorMessages(Map.of("error", "internal server error"), HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<?> responseErrorMessages(Map<String, String> messages, HttpStatus status) {
        return new ResponseEntity<>(messages, status);
    }

    private Map.Entry<String, String> createFieldErrorMessage(FieldError fieldError) {
        return Map.entry(fieldError.getField(), Objects.requireNonNull(fieldError.getDefaultMessage()));

    }
}