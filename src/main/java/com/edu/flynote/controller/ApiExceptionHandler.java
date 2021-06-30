package com.edu.flynote.controller;

import com.edu.flynote.check.SpamForbiddenException;
import com.edu.flynote.controller.dto.ErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {SpamForbiddenException.class})
    public ResponseEntity<Object> spaForbidden(RuntimeException exception) {
        return new ResponseEntity<Object>(
                new ErrorDto(exception.getMessage()), new HttpHeaders(), HttpStatus.FORBIDDEN);
    }
}
