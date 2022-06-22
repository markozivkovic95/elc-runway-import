package com.example.runwayimport.exceptions.handlers;

import com.example.runwayimport.models.HttpResponse;
import com.example.runwayimport.utils.HttpUtils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String GENERAL_EXCEPTION_MESSAGE = "Server is unavailable now. Try again later.";
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<HttpResponse> serverError(final Exception e) {

        return HttpUtils.createHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR, GENERAL_EXCEPTION_MESSAGE);
    }

    @ExceptionHandler(HttpStatusCodeException.class)
    public ResponseEntity<HttpResponse> handleStatusCodeException(final HttpStatusCodeException e) {

        return HttpUtils.createHttpResponse(HttpStatus.valueOf(e.getRawStatusCode()), e.getLocalizedMessage());
    }

}
