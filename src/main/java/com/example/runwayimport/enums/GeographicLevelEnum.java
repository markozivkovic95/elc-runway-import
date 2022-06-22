package com.example.runwayimport.enums;

public enum GeographicLevelEnum {
    
    GLOBAL("Global");

    private final String key;

    GeographicLevelEnum(final String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}
