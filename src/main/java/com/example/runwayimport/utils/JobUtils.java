package com.example.runwayimport.utils;

import java.util.List;

import com.example.runwayimport.constants.FieldNameConstants;
import com.example.runwayimport.constants.TechnicalNameConstants;
import com.example.runwayimport.models.JobCreateDTO;
import com.example.runwayimport.models.SearchParamsDTO;
import com.example.runwayimport.models.SearchVariableConditionDTO;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class JobUtils {

    private static final String RUNWAY_JOB_ID = "3076";
    
    private JobUtils() {

    }

    public static MultiValueMap<Object, Object> createJobRequest(final JobCreateDTO jobCreateDTO) {

        final MultiValueMap<Object, Object> result = new LinkedMultiValueMap<>();

        result.add(FieldNameConstants.DSE_OBJECT_TYPE_ID, jobCreateDTO.getDseObjectTypeId());
        result.add(FieldNameConstants.WORKFLOW_TYPE_ID, jobCreateDTO.getWorkflowTypeId());
        result.add(FieldNameConstants.JOB_NAME, jobCreateDTO.getName());
        result.add(FieldNameConstants.PARENT_JOB_ID, jobCreateDTO.getParentJobId());
        
        return result;
    }

    public static SearchParamsDTO searchRunwayJobsByNameRequest(final String value) {
        
        return new SearchParamsDTO(List.of(
                new SearchVariableConditionDTO(value, TechnicalNameConstants.JOB_NAME,
                    "AND", "EQUAL"), 
                new SearchVariableConditionDTO(
                        RUNWAY_JOB_ID, TechnicalNameConstants.JOB_TYPE_PSEUDO_VARIABLE,
                        "AND", "EQUAL"
                ))
        );
    }

}
