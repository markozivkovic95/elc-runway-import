package com.example.runwayimport.models;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.http.HttpStatus;

public class HttpResponse {
    
    private LocalDateTime timeStamp;
    private int httpStatusCode;
    private HttpStatus httpStatus;
    private String reason;
    private String message;

    public HttpResponse(final int httpStatusCode, final HttpStatus httpStatus, 
            final String reason, final String message) {
        
        this.timeStamp = LocalDateTime.now();
        this.httpStatusCode = httpStatusCode;
        this.httpStatus = httpStatus;
        this.reason = reason;
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return this.timeStamp;
    }

    public HttpResponse setTimeStamp(final LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
        return this;
    }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public HttpResponse setHttpStatusCode(final int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
        return this;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public HttpResponse setHttpStatus(final HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }

    public String getReason() {
        return this.reason;
    }

    public HttpResponse setReason(final String reason) {
        this.reason = reason;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public HttpResponse setMessage(final String message) {
        this.message = message;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof HttpResponse)) {
            return false;
        }
        HttpResponse httpResponse = (HttpResponse) o;
        return Objects.equals(timeStamp, httpResponse.timeStamp) &&
                httpStatusCode == httpResponse.httpStatusCode &&
                Objects.equals(httpStatus, httpResponse.httpStatus) &&
                Objects.equals(reason, httpResponse.reason) &&
                Objects.equals(message, httpResponse.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeStamp, httpStatusCode, httpStatus, reason, message);
    }

    @Override
    public String toString() {
        return "{" +
            " timeStamp='" + getTimeStamp() + "'" +
            ", httpStatusCode='" + getHttpStatusCode() + "'" +
            ", httpStatus='" + getHttpStatus() + "'" +
            ", reason='" + getReason() + "'" +
            ", message='" + getMessage() + "'" +
            "}";
    }

}
