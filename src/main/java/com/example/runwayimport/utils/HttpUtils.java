package com.example.runwayimport.utils;

import com.example.runwayimport.models.HttpResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HttpUtils {
    
    private HttpUtils() {

    }

    /**
     * Create HTTP response
     * 
     * @param httpStatus HTTP response status
     * @param message    Response message
     * @return created response of type {@link HttpResponse}
     */
    public static ResponseEntity<HttpResponse> createHttpResponse(final HttpStatus httpStatus, final String message) {

        final HttpResponse httpResponse = 
                new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase(), message);

        return new ResponseEntity<>(httpResponse, httpStatus);
    }

}
