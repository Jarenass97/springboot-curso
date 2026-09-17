package com.jorge.curso.springboot.error.springboot.error.controllers;

import java.util.Date;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.jorge.curso.springboot.error.springboot.error.exceptions.UserNotFoundException;
import com.jorge.curso.springboot.error.springboot.error.models.Error;

@RestControllerAdvice
public class HandlerExceptionController {

    private static final String ERROR_DIVISION_BY_ZERO = "Error division by zero";
    private static final String ERROR_NOT_FOUND = "Api rest no encontrado";
    private static final String ERROR_NUMBER_FORMAT = "Número inválido o incorrecto, no tiene formato de dígito!";
    private static final String ERROR_USER_NOT_FOUND = "Usuario no encontrado";
    private static final String ERROR_GENERIC = "Error genérico no controlado";

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Error> divisionByZero(Exception ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        Error error = new Error();
        error.setMessage(ex.getMessage());
        error.setError(ERROR_DIVISION_BY_ZERO);
        error.setStatus(status.value());
        error.setDate(new Date());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFoundException(NoHandlerFoundException e) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        Error error = new Error();
        error.setMessage(e.getMessage());
        error.setError(ERROR_NOT_FOUND);
        error.setStatus(status.value());
        error.setDate(new Date());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<Error> numberFormatException(NumberFormatException e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        Error error = new Error();
        error.setMessage(e.getMessage());
        error.setError(ERROR_NUMBER_FORMAT);
        error.setStatus(status.value());
        error.setDate(new Date());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler({ NullPointerException.class, HttpMessageNotWritableException.class,
            UserNotFoundException.class })
    public ResponseEntity<Error> userNotFoundException(Exception e) {
        ResponseStatus annotation = AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class);
        HttpStatus status = (annotation != null) ? annotation.value() : HttpStatus.INTERNAL_SERVER_ERROR;
        Error error = new Error();
        error.setMessage(e.getMessage());
        error.setError(ERROR_USER_NOT_FOUND);
        error.setStatus(status.value());
        error.setDate(new Date());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> internalServerError(Exception e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        Error error = new Error();
        error.setMessage(e.getMessage());
        error.setError(ERROR_GENERIC);
        error.setStatus(status.value());
        error.setDate(new Date());
        error.setException(e.getClass().getSimpleName());
        return ResponseEntity.status(status).body(error);
    }
}
