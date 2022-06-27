package com.example.runwayimport.utils;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.example.runwayimport.constants.FieldNameConstants;
import com.example.runwayimport.constants.OcdGridConstants;
import com.example.runwayimport.constants.ProductGridConstants;
import com.example.runwayimport.constants.TechnicalNameConstants;
import com.example.runwayimport.enums.InheritFromParentEnum;
import com.example.runwayimport.models.CustomStructureDTO;
import com.example.runwayimport.models.CustomValueDTO;
import com.example.runwayimport.models.JobCreateDTO;
import com.example.runwayimport.models.JobDTO;
import com.example.runwayimport.models.JobUpdateDTO;
import com.example.runwayimport.models.ProductDTO;
import com.example.runwayimport.models.ProgramOnCounterDateDTO;
import com.example.runwayimport.models.RunwayRequestDTO;
import com.example.runwayimport.models.SearchParamsDTO;
import com.example.runwayimport.models.SearchVariableConditionDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class JobUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String KEY_VALUE_FORMAT = "\\\"%s\\\":\\\"%s\\\",";

    public static final Integer RUNWAY_JOB_ID = 3076;
    public static final Integer RUNWAY_WORKFLOW_ID = 103;
    
    private JobUtils() {

    }

    public static MultiValueMap<Object, Object> mapJobCreateRequest(final JobCreateDTO jobCreateDTO) {

        final MultiValueMap<Object, Object> result = new LinkedMultiValueMap<>();

        result.add(FieldNameConstants.DSE_OBJECT_TYPE_ID, jobCreateDTO.getDseObjectTypeId());
        result.add(FieldNameConstants.WORKFLOW_TYPE_ID, jobCreateDTO.getWorkflowTypeId());
        result.add(FieldNameConstants.JOB_NAME, jobCreateDTO.getName());
        result.add(FieldNameConstants.PARENT_JOB_ID, jobCreateDTO.getParentJobId());
        
        return result;
    }

    public static JobUpdateDTO mapJobUpdateRequest(final JobDTO jobDTO, final RunwayRequestDTO request,
            final Map<String, List<CustomStructureDTO>> customStructures) {

        final List<CustomValueDTO> values = mapAllRequestParameters(request, customStructures).stream()
                .filter(value -> StringUtils.isNotBlank(value.getValue()))
                .collect(Collectors.toList());

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

    public static String mapProductsGridInRequestString(final List<ProductDTO> productDTOs, final Map<String, List<CustomStructureDTO>> customStructures) {

        final String requestString = "\"[%s]\"";

        if (CollectionUtils.isEmpty(productDTOs)) {
            return String.format(requestString, "");
        }

        final List<String> jsonObjects = new ArrayList<>();

        IntStream.range(0, productDTOs.size()).forEach(i -> {
            
            final ProductDTO product = productDTOs.get(i);
            
            final Map<Integer, String> productParameter = parseProductGridParameters(product, customStructures);
            jsonObjects.add(mapToJsonObject(productParameter, i + 1));
        });

        return String.format("\"%s\"", jsonObjects);
    }

    public static String mapOcdGridRequestString(final List<ProgramOnCounterDateDTO> programOnCounterDates, final Map<String, List<CustomStructureDTO>> customStructures) {
        
        final String requestString = "\"[%s]\"";

        if (CollectionUtils.isEmpty(programOnCounterDates)) {
            return String.format(requestString, "");
        }

        final List<String> jsonObjects = new ArrayList<>();

        IntStream.range(0, programOnCounterDates.size()).forEach(i -> {
            
            final ProgramOnCounterDateDTO programOnCounterDateDTO = programOnCounterDates.get(i);
            
            final Map<Integer, String> programParameters = parseOcdGridParameters(programOnCounterDateDTO, customStructures);
            jsonObjects.add(mapToJsonObject(programParameters, i + 1));
        });

        return String.format("\"%s\"", jsonObjects);
    }

    private static Map<Integer, String> parseOcdGridParameters(final ProgramOnCounterDateDTO programOnCounter, Map<String, List<CustomStructureDTO>> customStructures) {
        
        final Map<Integer, String> parameters = new HashMap<>();

        parameters.put(
            OcdGridConstants.OCD_GRID_REQUEST_CONSTANTS.get(FieldNameConstants.REGION),
            getValueByLabel(programOnCounter.getRegion(), customStructures.get(OcdGridConstants.PM_REGION))
        );

        parameters.put(
            OcdGridConstants.OCD_GRID_REQUEST_CONSTANTS.get(FieldNameConstants.AFFILIATE),
            getValueByLabel(programOnCounter.getAffiliate(), customStructures.get(OcdGridConstants.PM_AFFILIATE))
        );

        parameters.put(OcdGridConstants.OCD_GRID_REQUEST_CONSTANTS.get(FieldNameConstants.REGIONAL_ON_COUNTER_DATE), programOnCounter.getRegionalOnCounterDate());
        parameters.put(OcdGridConstants.OCD_GRID_REQUEST_CONSTANTS.get(FieldNameConstants.AFFILIATE_ON_COUNTER_DATE), programOnCounter.getAffiliateOnCounterDate());

        return parameters;
    }

    private static String formatJsonValue(final String value) {

        if (StringUtils.isBlank(value)) {
            return null;
        }

        try {
            return OBJECT_MAPPER.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            
            throw new InvalidParameterException(
                String.format(
                    "Parsing parameter %s to JSON failed.",
                    value
                )
            );
        }
    }

    private static String mapToJsonObject(final Map<Integer, String> parametersToBeMapped, final int id) {

        final StringBuilder sb = new StringBuilder();
        
        sb.append("{");

        parametersToBeMapped.forEach((key, value) -> 
            sb.append(String.format(KEY_VALUE_FORMAT, key, value))
        );

        sb.append(String.format(KEY_VALUE_FORMAT, "id", id));

        // remove last character
        sb.setLength(sb.length() - 1);
        sb.append("}");

        return sb.toString();
    }

    private static Map<Integer, String> parseProductGridParameters(final ProductDTO product, final Map<String, List<CustomStructureDTO>> customStructures) {

        final Map<Integer, String> productParameters = new HashMap<>();
        final List<CustomStructureDTO> customStructureDTOs = customStructures.get(ProductGridConstants.PM_PRODUCT_NAME);

        final CustomStructureDTO cs = customStructureDTOs.stream()
                .filter(c -> c.getValue().equals(product.getProductCode()))
                .findFirst()
                .orElseThrow();

        productParameters.put(ProductGridConstants.PRODUCT_GRID_REQUEST_CONSTANTS.get(FieldNameConstants.PRODUCT_CODE), cs.getValue());

        productParameters.put(
                ProductGridConstants.PRODUCT_GRID_REQUEST_CONSTANTS.get(FieldNameConstants.PRODUCT_LINE), 
                getValueByLabel(product.getProductLine(), customStructures.get(ProductGridConstants.PM_PRODUCT_LINE))
        );

        productParameters.put(
                ProductGridConstants.PRODUCT_GRID_REQUEST_CONSTANTS.get(FieldNameConstants.PRODUCT_ROLE), 
                getValueByLabel(product.getProductRole(), customStructures.get(ProductGridConstants.PM_PRODUCT_ROLE))
        );
        
        productParameters.put(
                ProductGridConstants.PRODUCT_GRID_REQUEST_CONSTANTS.get(FieldNameConstants.MAJOR_CATEGORY), 
                getValueByLabel(product.getMajorCategory(), customStructures.get(ProductGridConstants.PM_MAJOR_CATEGORY))
        );

        productParameters.put(
                ProductGridConstants.PRODUCT_GRID_REQUEST_CONSTANTS.get(FieldNameConstants.APPLICATION), 
                getValueByLabel(product.getApplication(), customStructures.get(ProductGridConstants.PM_APPLICATION))
        );

        productParameters.put(
                ProductGridConstants.PRODUCT_GRID_REQUEST_CONSTANTS.get(FieldNameConstants.CATEGORY), 
                getValueByLabel(product.getCategory(), customStructures.get(ProductGridConstants.PM_CATEGORY))
        );

        productParameters.put(
                ProductGridConstants.PRODUCT_GRID_REQUEST_CONSTANTS.get(FieldNameConstants.SUB_CATEGORY), 
                getValueByLabel(product.getSubCategory(), customStructures.get(ProductGridConstants.PM_SUB_CATEGORY))
        );

        productParameters.put(
                ProductGridConstants.PRODUCT_GRID_REQUEST_CONSTANTS.get(FieldNameConstants.DEMAND_TYPE), 
                getValueByLabel(product.getDemandType(), customStructures.get(ProductGridConstants.PM_DEMAND_TYPE))
        );

        productParameters.put(
                ProductGridConstants.PRODUCT_GRID_REQUEST_CONSTANTS.get(FieldNameConstants.SALEABLE), 
                getValueByLabel(product.getSaleable(), customStructures.get(ProductGridConstants.YES_NO_NA))
        );

        return productParameters;
    }

    private static String getValueByLabel(final String label, final List<CustomStructureDTO> customStructureDTOs) {

        final CustomStructureDTO customStructureDTO = customStructureDTOs.stream()
                .filter(structure -> structure.getLabel().equals(label))
                .findFirst()
                .orElse(null);

        return customStructureDTO != null ? customStructureDTO.getValue() : "";
    }

    private static String formattedGetValueByLabel(final String label, final List<CustomStructureDTO> customStructureDTOs) {

        final String value = getValueByLabel(label, customStructureDTOs);

        if (StringUtils.isNotBlank(value)) {
            return String.format("\"%s\"", value);
        }

        return "";
    }

    private static String getValueByLabelAndParentValue(final String label, final String parentValue, final List<CustomStructureDTO> customStructureDTOs) {

        final CustomStructureDTO customStructureDTO = customStructureDTOs.stream()
                .filter(structure -> structure.getLabel().equals(label) && structure.getParent().equals(parentValue))
                .findFirst()
                .orElse(null);

        return customStructureDTO != null ? customStructureDTO.getValue() : "";
    }

    private static String formattedGetValueByLabelAndParentValue(final String label, final String parentValue, final List<CustomStructureDTO> customStructureDTOs) {

        final String value = getValueByLabelAndParentValue(label, parentValue, customStructureDTOs);

        if (StringUtils.isNotBlank(value)) {
            return String.format("\"%s\"", value);
        }

        return "";
    }

    private static List<CustomValueDTO> mapAllRequestParameters(final RunwayRequestDTO request, final Map<String, List<CustomStructureDTO>> customStructures) {

        final List<CustomValueDTO> values = new ArrayList<>();
        final String majorCategoryValue = getValueByLabel(request.getMajorCategory(), customStructures.get(ProductGridConstants.PM_MAJOR_CATEGORY));
        final String formattedApplicationValue = formattedGetValueByLabelAndParentValue(request.getApplication(), majorCategoryValue, customStructures.get(ProductGridConstants.PM_APPLICATION));

        values.add(new CustomValueDTO(TechnicalNameConstants.PROGRAM_ID, InheritFromParentEnum.NOT_SUPPORTED.getKey(), formatJsonValue(request.getProgramId())));
        values.add(new CustomValueDTO(TechnicalNameConstants.GLOBAL_PROGRAM_ID, InheritFromParentEnum.NOT_SUPPORTED.getKey(), formatJsonValue(request.getProgramId())));
        values.add(new CustomValueDTO(TechnicalNameConstants.JOB_NAME, InheritFromParentEnum.NOT_SUPPORTED.getKey(), formatJsonValue(request.getProgramName())));
        values.add(new CustomValueDTO(TechnicalNameConstants.BRAND, InheritFromParentEnum.NOT_SUPPORTED.getKey(), formattedGetValueByLabel(request.getProgramBrand(), customStructures.get(ProductGridConstants.PM_BRAND))));
        values.add(new CustomValueDTO(TechnicalNameConstants.PRODUCT_LINE, InheritFromParentEnum.NOT_SUPPORTED.getKey(), formattedGetValueByLabel(request.getProductLine(), customStructures.get(ProductGridConstants.PM_PRODUCT_LINE))));
        values.add(new CustomValueDTO(TechnicalNameConstants.PROGRAM_STATUS, InheritFromParentEnum.NOT_SUPPORTED.getKey(), formattedGetValueByLabel(request.getProgramStatus(), customStructures.get(ProductGridConstants.PM_PROGRAM_STATUS))));
        values.add(new CustomValueDTO(TechnicalNameConstants.PROGRAM_START_DATE, InheritFromParentEnum.NOT_SUPPORTED.getKey(), formatJsonValue(request.getProgramStartDate())));
        values.add(new CustomValueDTO(TechnicalNameConstants.PROGRAM_END_DATE, InheritFromParentEnum.NOT_SUPPORTED.getKey(), formatJsonValue(request.getProgramEndDate())));
        values.add(new CustomValueDTO(TechnicalNameConstants.PROGRAM_TYPE, InheritFromParentEnum.NOT_SUPPORTED.getKey(), formattedGetValueByLabel(request.getProgramType(), customStructures.get(ProductGridConstants.PM_PROGRAM_TYPE))));
        values.add(new CustomValueDTO(TechnicalNameConstants.PRIORITY, InheritFromParentEnum.NOT_SUPPORTED.getKey(), formattedGetValueByLabel(request.getPriority(), customStructures.get(ProductGridConstants.PM_PRIORITY))));
        values.add(new CustomValueDTO(TechnicalNameConstants.PRODUCT_ROLE, InheritFromParentEnum.NOT_SUPPORTED.getKey(), formattedGetValueByLabel(request.getProductRole(), customStructures.get(ProductGridConstants.PM_PRODUCT_ROLE))));
        values.add(new CustomValueDTO(TechnicalNameConstants.MAJOR_INVENTORY_TYPE, InheritFromParentEnum.NOT_SUPPORTED.getKey(), formattedGetValueByLabel(request.getMajorInventoryType(), customStructures.get(ProductGridConstants.PM_MAJOR_INVENTORY_TYPE))));
        values.add(new CustomValueDTO(TechnicalNameConstants.INVENTORY_TYPE, InheritFromParentEnum.NOT_SUPPORTED.getKey(), formattedGetValueByLabel(request.getInventoryType(), customStructures.get(ProductGridConstants.PM_INVENTORY_TYPE))));
        values.add(new CustomValueDTO(TechnicalNameConstants.MAJOR_CATEGORY, InheritFromParentEnum.NOT_SUPPORTED.getKey(), formatJsonValue(majorCategoryValue)));
        values.add(new CustomValueDTO(TechnicalNameConstants.APPLICATION, InheritFromParentEnum.NOT_SUPPORTED.getKey(), formattedApplicationValue));
        values.add(new CustomValueDTO(TechnicalNameConstants.CATEGORY, InheritFromParentEnum.NOT_SUPPORTED.getKey(), formattedGetValueByLabel(request.getCategory(), customStructures.get(ProductGridConstants.PM_CATEGORY))));
        values.add(new CustomValueDTO(TechnicalNameConstants.SUB_CATEGORY, InheritFromParentEnum.NOT_SUPPORTED.getKey(), formattedGetValueByLabel(request.getSubCategory(), customStructures.get(ProductGridConstants.PM_SUB_CATEGORY))));
        values.add(new CustomValueDTO(TechnicalNameConstants.SUB_CATEGORY_PRIORITY, InheritFromParentEnum.NOT_SUPPORTED.getKey(), formattedGetValueByLabel(request.getSubCategoryPriority(), customStructures.get(ProductGridConstants.PM_SUB_CATEGORY_PRIORITY))));
        values.add(new CustomValueDTO(TechnicalNameConstants.SEASON, InheritFromParentEnum.NOT_SUPPORTED.getKey(), formattedGetValueByLabel(request.getSeason(), customStructures.get(ProductGridConstants.PM_SEASON))));
        values.add(new CustomValueDTO(TechnicalNameConstants.QUARTER, InheritFromParentEnum.NOT_SUPPORTED.getKey(), formattedGetValueByLabel(request.getQuarter(), customStructures.get(ProductGridConstants.PM_QUARTER))));
        values.add(new CustomValueDTO(TechnicalNameConstants.SOURCE_FACTORY_SHIP_DATE, InheritFromParentEnum.NOT_SUPPORTED.getKey(), formatJsonValue(request.getSourceFactoryShipDate())));
        values.add(
            new CustomValueDTO(TechnicalNameConstants.PRODUCTS_GRID, InheritFromParentEnum.NOT_SUPPORTED.getKey(),
                    mapProductsGridInRequestString(request.getProducts(), customStructures))
        );
        values.add(
            new CustomValueDTO(
                TechnicalNameConstants.OCD_GRID, InheritFromParentEnum.NOT_SUPPORTED.getKey(), mapOcdGridRequestString(request.getProgramOnCounterDates(), customStructures)
            )
        );

        return values;
    }

}
