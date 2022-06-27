package com.example.runwayimport.exceptions.handlers;

import com.example.runwayimport.models.HttpResponse;
import com.example.runwayimport.utils.HttpUtils;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<Void> serverError(final JsonProcessingException e) {

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(HttpStatusCodeException.class)
    public ResponseEntity<HttpResponse> handleStatusCodeException(final HttpStatusCodeException e) {

        return HttpUtils.createHttpResponse(HttpStatus.valueOf(e.getRawStatusCode()), e.getLocalizedMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Void> methodNotSupported() {
        
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
}
