package com.example.runwayimport.constants;

public class EndpointConstants {

    private EndpointConstants() {
        
    }
    
    public static final String ELC_BRANDMAKER = "https://elc.brandmaker.com/dse/rest";
    public static final String ELC_BRANDMAKER_V1 = ELC_BRANDMAKER + "/v1.0";
    public static final String ELC_BRANDMAKER_JOBS = ELC_BRANDMAKER_V1 + "/jobs";
    public static final String ELC_BRANDMAKER_JOBS_WITH_ID = ELC_BRANDMAKER_JOBS + "/%s";
    public static final String ELC_BRANDMAKER_JOBS_SEARCH = ELC_BRANDMAKER_JOBS + "/_search";
    
    public static final String ELC_BRANDMAKER_UI = ELC_BRANDMAKER + "/ui";
    public static final String ELC_BRANDMAKER_UI_OBJECTS = ELC_BRANDMAKER_UI + "/objects";
    public static final String ELC_BRANDMAKER_UI_OBJECTS_WITH_ID = ELC_BRANDMAKER_UI_OBJECTS + "/%s";
    public static final String ELC_BRANDMAKER_UI_OBJECTS_WITH_ID_CUSTOM_STRUCTURES = ELC_BRANDMAKER_UI_OBJECTS_WITH_ID + "/custom-structures";

    public static final String ELC_BRANDMAKER_DSE_OBJECT = ELC_BRANDMAKER_V1 + "/dse-object";
    public static final String ELC_BRANDMAKER_DSE_OBJECT_WITH_ID = ELC_BRANDMAKER_DSE_OBJECT + "/%s/0";

    public static final String INTERNAL_ELC_BRANDMAKER = ELC_BRANDMAKER + "/internal";
    public static final String INTERNAL_ELC_BRANDMAKER_DSE_OBJECT = INTERNAL_ELC_BRANDMAKER + "/dse-object";
    public static final String INTERNAL_ELC_BRANDMAKER_DSE_OBJECT_CREATE = INTERNAL_ELC_BRANDMAKER_DSE_OBJECT + "/create";
    public static final String INTERNAL_ELC_BRANDMAKER_DSE_OBJECT_UPDATE = INTERNAL_ELC_BRANDMAKER_DSE_OBJECT + "/update";

}
