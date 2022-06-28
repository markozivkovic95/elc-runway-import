package com.example.runwayimport.constants;

public class EndpointConstants {

    private EndpointConstants() {
        
    }
    
    public static final String DSE_REST = "/dse/rest";
    public static final String DSE_REST_V1 = DSE_REST + "/v1.0";
    public static final String DSE_REST_JOBS = DSE_REST_V1 + "/jobs";
    public static final String DSE_REST_JOBS_WITH_ID = DSE_REST_JOBS + "/%s";
    public static final String DSE_REST_JOBS_SEARCH = DSE_REST_JOBS + "/_search";

    public static final String DSE_REST_UI = DSE_REST + "/ui";
    public static final String DSE_REST_UI_OBJECTS = DSE_REST_UI + "/objects";
    public static final String DSE_REST_UI_OBJECTS_WITH_ID = DSE_REST_UI_OBJECTS + "/%s";
    public static final String DSE_REST_UI_OBJECTS_WITH_ID_CUSTOM_STRUCTURES = DSE_REST_UI_OBJECTS_WITH_ID + "/custom-structures";

    public static final String DSE_REST_DSE_OBJECT = DSE_REST_V1 + "/dse-object";
    public static final String DSE_REST_DSE_OBJECT_WITH_ID = DSE_REST_DSE_OBJECT + "/%s/0";
    
    public static final String DSE_REST_INTERNAL = DSE_REST + "/internal";
    public static final String DSE_REST_INTERNAL_DSE_OBJECT = DSE_REST_INTERNAL + "/dse-object";
    public static final String DSE_REST_INTERNAL_DSE_OBJECT_CREATE = DSE_REST_INTERNAL_DSE_OBJECT + "/create";
    public static final String DSE_REST_INTERNAL_DSE_OBJECT_UPDATE = DSE_REST_INTERNAL_DSE_OBJECT + "/update";

}
