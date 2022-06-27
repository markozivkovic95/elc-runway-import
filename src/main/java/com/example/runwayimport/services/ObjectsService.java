package com.example.runwayimport.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.runwayimport.constants.EndpointConstants;
import com.example.runwayimport.models.CustomStructureDTO;
import com.example.runwayimport.utils.RestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ObjectsService {
    
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public ObjectsService(final RestTemplate restTemplate, final ObjectMapper objectMapper) {
        
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public Map<String, List<CustomStructureDTO>> getCustomStructures(final Integer jobId) {

        final Map<Object, Object> response = RestUtils.sendGetRequest(
                restTemplate,
                String.format(EndpointConstants.ELC_BRANDMAKER_UI_OBJECTS_WITH_ID_CUSTOM_STRUCTURES, jobId)
        );

        return this.objectMapper.convertValue(response, TypeFactory.defaultInstance().constructMapType(
                HashMap.class, 
                this.objectMapper.constructType(String.class), 
                TypeFactory.defaultInstance().constructCollectionType(List.class, CustomStructureDTO.class))
        );
    }

}
