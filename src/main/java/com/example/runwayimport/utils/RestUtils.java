package com.example.runwayimport.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class RestUtils {

    private static final ParameterizedTypeReference<Map<Object, Object>> RESPONSE_TYPE = new ParameterizedTypeReference<Map<Object, Object>>() {};
    
    private RestUtils() {

    }

    @SuppressWarnings("unchecked")
    public static Map<Object, Object> sendGetRequest(final RestTemplate restTemplate, final String endpoint) {
        
        return restTemplate.getForEntity(
                endpoint,
                HashMap.class
        ).getBody();
    }

    public static Map<Object, Object> sendPostRequest(final RestTemplate restTemplate, final String endpoint, final HttpEntity<?> httpEntity) {

        return restTemplate.exchange(
                endpoint,
                HttpMethod.POST,
                httpEntity,
                RESPONSE_TYPE
        ).getBody();
    }
}
