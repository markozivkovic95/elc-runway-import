package com.example.runwayimport.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.example.runwayimport.constants.FieldNameConstants;
import com.example.runwayimport.constants.ProductGridConstants;
import com.example.runwayimport.constants.TechnicalNameConstants;
import com.example.runwayimport.enums.InheritFromParentEnum;
import com.example.runwayimport.models.CustomStructureDTO;
import com.example.runwayimport.models.CustomValueDTO;
import com.example.runwayimport.models.JobCreateDTO;
import com.example.runwayimport.models.JobDTO;
import com.example.runwayimport.models.JobUpdateDTO;
import com.example.runwayimport.models.ProductDTO;
import com.example.runwayimport.models.RunwayRequestDTO;
import com.example.runwayimport.models.SearchParamsDTO;
import com.example.runwayimport.models.SearchVariableConditionDTO;

import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class JobUtils {

    private static final String KEY_VALUE_FORMAT = "\\\"%s\\\":\\\"%s\\\",";

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

    public static JobUpdateDTO createJobUpdateRequest(final JobDTO jobDTO, final RunwayRequestDTO request,
            final Map<String, List<CustomStructureDTO>> customStructures) {

        final List<CustomValueDTO> values = addParameters(request, customStructures).stream()
                .filter(value -> value.getValue() != null)
                .collect(Collectors.toList());

        return new JobUpdateDTO(jobDTO.getInstanceId(), jobDTO.getL10nLocaleId(), 0, values);
    }

    public static SearchParamsDTO searchRunwayJobsByNameRequest(final String value) {
        
        final String formattedValue = value.replace("\"", "");

        return new SearchParamsDTO(List.of(
                new SearchVariableConditionDTO(formattedValue, TechnicalNameConstants.JOB_NAME,
                    "AND", "EQUAL"), 
                new SearchVariableConditionDTO(
                        RUNWAY_JOB_ID.toString(), TechnicalNameConstants.JOB_TYPE_PSEUDO_VARIABLE,
                        "AND", "EQUAL"
                ))
        );
    }

    public static String mapProductsGridInRequestString(final List<ProductDTO> productDTOs, final Map<String, List<CustomStructureDTO>> customStructures) {

        final String requestString = "\"[%s]\"";

        if (CollectionUtils.isEmpty(productDTOs)) {
            return String.format(requestString, "");
        }

        final List<String> jsonObjects = new ArrayList<>();

        IntStream.range(0, productDTOs.size()).forEach(i -> {
            final ProductDTO product = productDTOs.get(i);

            
            final Map<Integer, String> productParameter = parseProductGridParameters(product, customStructures);
            jsonObjects.add(mapProductMapperToJson(productParameter, i + 1));
        });

        return String.format("\\\"%s\\\"", jsonObjects);
    }

    private static String mapProductMapperToJson(final Map<Integer, String> productParameter, final int id) {

        final StringBuilder sb = new StringBuilder();
        
        sb.append("{");

        productParameter.forEach((key, value) -> {
            sb.append(String.format(KEY_VALUE_FORMAT, key, value));
        });

        sb.append(String.format(KEY_VALUE_FORMAT, 12, ""));
        sb.append(String.format(KEY_VALUE_FORMAT, "id", id));

        // remove last character
        sb.setLength(sb.length() - 1);
        sb.append("}");

        return sb.toString().replace("\\", "\\\\\\");
    }

    private static Map<Integer, String> parseProductGridParameters(final ProductDTO product, final Map<String, List<CustomStructureDTO>> customStructures) {

        final Map<Integer, String> productParameters = new HashMap<>();
        final List<CustomStructureDTO> customStructureDTOs = customStructures.get(getCustomStructureKey(FieldNameConstants.PRODUCT_NAME));

        final CustomStructureDTO cs = customStructureDTOs.stream()
                .filter(c -> c.getValue().equals(product.getProductCode()))
                .findFirst()
                .orElseThrow();

        productParameters.put(
                ProductGridConstants.PRODUCT_GRID_REQUEST_CONSTANTS.get(FieldNameConstants.PRODUCT_CODE), 
                cs.getValue()
        );

        productParameters.put(
                ProductGridConstants.PRODUCT_GRID_REQUEST_CONSTANTS.get(FieldNameConstants.PRODUCT_LINE), 
                getValue(product.getProductLine(), customStructures.get(getCustomStructureKey(FieldNameConstants.PRODUCT_LINE)))
        );

        productParameters.put(
                ProductGridConstants.PRODUCT_GRID_REQUEST_CONSTANTS.get(FieldNameConstants.PRODUCT_ROLE), 
                getValue(product.getProductRole(), customStructures.get(getCustomStructureKey(FieldNameConstants.PRODUCT_ROLE)))
        );
        
        productParameters.put(
                ProductGridConstants.PRODUCT_GRID_REQUEST_CONSTANTS.get(FieldNameConstants.MAJOR_CATEGORY), 
                getValue(product.getMajorCategory(), customStructures.get(getCustomStructureKey(FieldNameConstants.MAJOR_CATEGORY)))
        );

        productParameters.put(
                ProductGridConstants.PRODUCT_GRID_REQUEST_CONSTANTS.get(FieldNameConstants.APPLICATION), 
                getValue(product.getApplication(), customStructures.get(getCustomStructureKey(FieldNameConstants.APPLICATION)))
        );

        productParameters.put(
                ProductGridConstants.PRODUCT_GRID_REQUEST_CONSTANTS.get(FieldNameConstants.CATEGORY), 
                getValue(product.getCategory(), customStructures.get(getCustomStructureKey(FieldNameConstants.CATEGORY)))
        );

        productParameters.put(
                ProductGridConstants.PRODUCT_GRID_REQUEST_CONSTANTS.get(FieldNameConstants.SUB_CATEGORY), 
                getValue(product.getSubCategory(), customStructures.get(getCustomStructureKey(FieldNameConstants.SUB_CATEGORY)))
        );

        productParameters.put(
                ProductGridConstants.PRODUCT_GRID_REQUEST_CONSTANTS.get(FieldNameConstants.DEMAND_TYPE), 
                getValue(product.getDemandType(), customStructures.get(getCustomStructureKey(FieldNameConstants.DEMAND_TYPE)))
        );

        productParameters.put(
                ProductGridConstants.PRODUCT_GRID_REQUEST_CONSTANTS.get(FieldNameConstants.SALEABLE), 
                getValue(product.getSaleable(), customStructures.get(getCustomStructureKey(FieldNameConstants.SALEABLE)))
        );

        return productParameters;
    }

    private static String getValue(final String label, final List<CustomStructureDTO> customStructureDTOs) {

        final CustomStructureDTO customStructureDTO = customStructureDTOs.stream()
                .filter(structure -> structure.getLabel().equals(label))
                .findFirst()
                .orElse(null);

        return customStructureDTO != null ? customStructureDTO.getValue() : "";
    }

    private static String getCustomStructureKey(final String key) {

        switch (key) {
            case FieldNameConstants.SALEABLE:
                
                return "PM_Yes_No_NA";
            case FieldNameConstants.MAJOR_CATEGORY:
                
                return "PM_Product_Application_Major_Category";
            case FieldNameConstants.APPLICATION:
                
                return "PM_Product_Application";
            case FieldNameConstants.CATEGORY:
                
                return "PM_Product_Application_Category";

            case FieldNameConstants.SUB_CATEGORY:
                return "PM_Product_Application_Sub_Category";
            default:
                return String.format("PM_%s", key);
        }
    }

    private static List<CustomValueDTO> addParameters(final RunwayRequestDTO request, final Map<String, List<CustomStructureDTO>> customStructures) {

        final List<CustomValueDTO> values = new ArrayList<>();

        values.add(new CustomValueDTO(TechnicalNameConstants.PROGRAM_ID, InheritFromParentEnum.NOT_SUPPORTED.getKey(), request.getProgramId()));
        values.add(new CustomValueDTO(TechnicalNameConstants.GLOBAL_PROGRAM_ID, InheritFromParentEnum.NOT_SUPPORTED.getKey(), request.getProgramId()));
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
        values.add(
            new CustomValueDTO(TechnicalNameConstants.PRODUCTS_GRID, InheritFromParentEnum.NOT_SUPPORTED.getKey(),
                    mapProductsGridInRequestString(request.getProducts(), customStructures))
        );

        return values;
    }

}
