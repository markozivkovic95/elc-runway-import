package com.example.runwayimport.enums;

public enum VisibilityEnum {
    SHOW("Show"),
    HIDE("Hide");

    private final String key;

    VisibilityEnum(final String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}
