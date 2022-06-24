package com.example.runwayimport.constants;

import java.util.Map;

public class ProductGridConstants {

    private ProductGridConstants() {

    }
    
    public static final Map<String, Integer> PRODUCT_GRID_REQUEST_CONSTANTS = Map.of(
            FieldNameConstants.PRODUCT_CODE, 11,
            FieldNameConstants.PRODUCT_LINE, 3,
            FieldNameConstants.PRODUCT_ROLE, 4,
            FieldNameConstants.MAJOR_CATEGORY, 5,
            FieldNameConstants.APPLICATION, 6,
            FieldNameConstants.CATEGORY, 7,
            FieldNameConstants.SUB_CATEGORY, 8,
            FieldNameConstants.DEMAND_TYPE, 9,
            FieldNameConstants.SALEABLE, 10
    );

}