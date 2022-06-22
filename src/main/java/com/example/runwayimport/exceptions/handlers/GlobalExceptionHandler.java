package com.example.runwayimport.exceptions.handlers;

import com.example.runwayimport.exceptions.ResourceNotFoundException;
import com.example.runwayimport.exceptions.ResourceStateException;
import com.example.runwayimport.models.HttpResponse;
import com.example.runwayimport.utils.HttpUtils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String GENERAL_EXCEPTION_MESSAGE = "Server is unavailable now. Try again later.";
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<HttpResponse> resourceNotFound(final ResourceNotFoundException e) {

        return HttpUtils.createHttpResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(ResourceStateException.class)
    public ResponseEntity<HttpResponse> resourceStateException(final ResourceStateException e) {

        return HttpUtils.createHttpResponse(HttpStatus.CONFLICT, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HttpResponse> serverError(final Exception e) {

        return HttpUtils.createHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR, GENERAL_EXCEPTION_MESSAGE);
    }


}
