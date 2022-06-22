package com.example.runwayimport.utils;

import java.util.ArrayList;
import java.util.List;

import com.example.runwayimport.constants.FieldNameConstants;
import com.example.runwayimport.constants.TechnicalNameConstants;
import com.example.runwayimport.enums.InheritFromParentEnum;
import com.example.runwayimport.models.CustomValueDTO;
import com.example.runwayimport.models.JobCreateDTO;
import com.example.runwayimport.models.JobDTO;
import com.example.runwayimport.models.JobUpdateDTO;
import com.example.runwayimport.models.RunwayRequestDTO;
import com.example.runwayimport.models.SearchParamsDTO;
import com.example.runwayimport.models.SearchVariableConditionDTO;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class JobUtils {

    public static final Integer RUNWAY_JOB_ID = 3076;
    public static final Integer RUNWAY_WORKFLOW_ID = 103;
    
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

    public static JobUpdateDTO createJobUpdateRequest(final JobDTO jobDTO, final RunwayRequestDTO request) {

        final List<CustomValueDTO> values = new ArrayList<>();

        values.add(new CustomValueDTO(TechnicalNameConstants.JOB_NAME, InheritFromParentEnum.NOT_SUPPORTED.getKey(), request.getProgramName()));
        values.add(new CustomValueDTO(TechnicalNameConstants.BRAND, InheritFromParentEnum.NOT_SUPPORTED.getKey(), request.getProgramBrand()));
        values.add(new CustomValueDTO(TechnicalNameConstants.PRODUCT_LINE, InheritFromParentEnum.NOT_SUPPORTED.getKey(), request.getProductLine()));
        values.add(new CustomValueDTO(TechnicalNameConstants.PROGRAM_STATUS, InheritFromParentEnum.NOT_SUPPORTED.getKey(), request.getProgramStatus()));
        values.add(new CustomValueDTO(TechnicalNameConstants.PROGRAM_START_DATE, InheritFromParentEnum.NOT_SUPPORTED.getKey(), request.getProgramStartDate()));
        values.add(new CustomValueDTO(TechnicalNameConstants.PROGRAM_END_DATE, InheritFromParentEnum.NOT_SUPPORTED.getKey(), request.getProgramEndDate()));
        values.add(new CustomValueDTO(TechnicalNameConstants.PROGRAM_TYPE, InheritFromParentEnum.NOT_SUPPORTED.getKey(), request.getProgramType()));
        values.add(new CustomValueDTO(TechnicalNameConstants.PRIORITY, InheritFromParentEnum.NOT_SUPPORTED.getKey(), request.getPriority()));
        values.add(new CustomValueDTO(TechnicalNameConstants.PRODUCT_ROLE, InheritFromParentEnum.NOT_SUPPORTED.getKey(), request.getProductRole()));
        values.add(new CustomValueDTO(TechnicalNameConstants.MAJOR_INVENTORY_TYPE, InheritFromParentEnum.NOT_SUPPORTED.getKey(), request.getMajorInventoryType()));
        values.add(new CustomValueDTO(TechnicalNameConstants.INVENTORY_TYPE, InheritFromParentEnum.NOT_SUPPORTED.getKey(), request.getInventoryType()));
        values.add(new CustomValueDTO(TechnicalNameConstants.MAJOR_CATEGORY, InheritFromParentEnum.NOT_SUPPORTED.getKey(), request.getMajorCategory()));
        values.add(new CustomValueDTO(TechnicalNameConstants.APPLICATION, InheritFromParentEnum.NOT_SUPPORTED.getKey(), request.getApplication()));
        values.add(new CustomValueDTO(TechnicalNameConstants.CATEGORY, InheritFromParentEnum.NOT_SUPPORTED.getKey(), request.getCategory()));
        values.add(new CustomValueDTO(TechnicalNameConstants.SUB_CATEGORY, InheritFromParentEnum.NOT_SUPPORTED.getKey(), request.getSubCategory()));
        values.add(new CustomValueDTO(TechnicalNameConstants.SUB_CATEGORY_PRIORITY, InheritFromParentEnum.NOT_SUPPORTED.getKey(), request.getSubCategoryPriority()));
        values.add(new CustomValueDTO(TechnicalNameConstants.SEASON, InheritFromParentEnum.NOT_SUPPORTED.getKey(), request.getSeason()));
        values.add(new CustomValueDTO(TechnicalNameConstants.QUARTER, InheritFromParentEnum.NOT_SUPPORTED.getKey(), request.getQuarter()));
        values.add(new CustomValueDTO(TechnicalNameConstants.SOURCE_FACTORY_SHIP_DATE, InheritFromParentEnum.NOT_SUPPORTED.getKey(), request.getSourceFactoryShipDate()));
        values.add(new CustomValueDTO(TechnicalNameConstants.PRODUCTS_GRID, InheritFromParentEnum.NOT_SUPPORTED.getKey(), request.getProducts()));

        return new JobUpdateDTO(jobDTO.getInstanceId(), jobDTO.getL10nLocaleId(), 0, values);
    }

    public static SearchParamsDTO searchRunwayJobsByNameRequest(final String value) {
        
        return new SearchParamsDTO(List.of(
                new SearchVariableConditionDTO(value, TechnicalNameConstants.JOB_NAME,
                    "AND", "EQUAL"), 
                new SearchVariableConditionDTO(
                        RUNWAY_JOB_ID.toString(), TechnicalNameConstants.JOB_TYPE_PSEUDO_VARIABLE,
                        "AND", "EQUAL"
                ))
        );
    }

}
