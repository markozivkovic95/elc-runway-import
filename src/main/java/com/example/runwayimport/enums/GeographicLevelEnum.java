package com.example.runwayimport.enums;

public enum GeographicLevelEnum {
    
    GLOBAL("1"),
    REGIONAL("2"),
    AFFILIATE("3");

    private final String key;

    GeographicLevelEnum(final String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}
