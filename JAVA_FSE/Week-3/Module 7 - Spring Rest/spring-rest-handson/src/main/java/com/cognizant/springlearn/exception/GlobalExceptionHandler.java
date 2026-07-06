package com.cognizant.springlearn.exception;

import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CountryNotFoundException.class)
    public ResponseEntity<Object> handleCountryNotFoundException(
            CountryNotFoundException ex) {

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        StringBuilder errors = new StringBuilder();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.append(error.getDefaultMessage()).append("\n");
        }

        return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
    }
}