package com.example.runwayimport.enums;

public enum JobStatusEnum {
    READY_FOR_PROCESSING("READY_FOR_PROCESSING"),
    PROCESSED("PROCESSED");

    private final String key;

    JobStatusEnum(final String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}
