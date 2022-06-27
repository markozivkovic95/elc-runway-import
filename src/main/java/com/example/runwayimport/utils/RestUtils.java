package com.example.runwayimport.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class RestUtils {

    private static final ParameterizedTypeReference<Map<Object, Object>> RESPONSE_TYPE = new ParameterizedTypeReference<Map<Object, Object>>() {};
    
    private RestUtils() {

    }

    public static Map<Object, Object> sendGetRequest(final RestTemplate restTemplate, final String endpoint) {
        
        final HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, getBearerToken());
        final HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                endpoint,
                HttpMethod.GET,
                requestEntity,
                RESPONSE_TYPE
        )
        .getBody();
    }

    public static Map<Object, Object> sendPostRequest(final RestTemplate restTemplate, final MediaType mediaType,
            final String endpoint, final Object requestBody) {

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);
        headers.set(HttpHeaders.AUTHORIZATION, getBearerToken());
        final HttpEntity<?> request = new HttpEntity<>(requestBody, headers);

        return restTemplate.exchange(
                endpoint,
                HttpMethod.POST,
                request,
                RESPONSE_TYPE
        ).getBody();
    }

    public static String getBearerToken() {

        final ServletRequestAttributes servletRequestAttributes = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());

        if (servletRequestAttributes != null) {

            return servletRequestAttributes.getRequest().getHeader(HttpHeaders.AUTHORIZATION);
        }

        return null;
    }

}
