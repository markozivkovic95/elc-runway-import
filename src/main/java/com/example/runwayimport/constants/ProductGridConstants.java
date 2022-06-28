package com.example.runwayimport.constants;

import java.util.Map;

public class ProductGridConstants {

    private ProductGridConstants() {

    }

    public static final String YES_NO_NA = "PM_Yes_No_NA";
    public static final String PM_BRAND = "PM_Brand";
    public static final String PM_PRODUCT_NAME = "PM_Product_Name";
    public static final String PM_PRODUCT_LINE = "PM_Product_Line";
    public static final String PM_PROGRAM_STATUS = "PM_Prog_Status";
    public static final String PM_PROGRAM_TYPE = "PM_Prog_Type";
    public static final String PM_PRIORITY = "PM_Priority";
    public static final String PM_PRODUCT_ROLE = "PM_Product_Role";
    public static final String PM_MAJOR_INVENTORY_TYPE = "PM_Major_Inventory_Type";
    public static final String PM_INVENTORY_TYPE = "PM_Inventory_Type";
    public static final String PM_MAJOR_CATEGORY = "PM_Product_Application_Major_Category";
    public static final String PM_APPLICATION = "PM_Product_Application";
    public static final String PM_CATEGORY = "PM_Product_Application_Category";
    public static final String PM_SUB_CATEGORY = "PM_Product_Application_Sub_Category";
    public static final String PM_SUB_CATEGORY_PRIORITY = "PM_SubCat_Priority";
    public static final String PM_SEASON = "PM_Season";
    public static final String PM_QUARTER = "PM_Quarter";
    public static final String PM_DEMAND_TYPE = "PM_Demand_Type";
    public static final String PM_INNOVATION_TYPE =  "PM_Innovation_Type";
    
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