package com.example.runwayimport.constants;

import java.util.Map;

public class OcdGridConstants {
    
    private OcdGridConstants() {

    }

    public static final String PM_REGION = "PM_Region";
    public static final String PM_AFFILIATE = "PM_Affiliate";

    public static final Map<String, Integer> OCD_GRID_REQUEST_CONSTANTS = Map.of(
            FieldNameConstants.REGION, 1,
            FieldNameConstants.REGIONAL_ON_COUNTER_DATE, 2,
            FieldNameConstants.AFFILIATE, 3,
            FieldNameConstants.AFFILIATE_ON_COUNTER_DATE, 4
    );
}
