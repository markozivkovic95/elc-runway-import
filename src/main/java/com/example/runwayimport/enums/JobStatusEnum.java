package com.example.runwayimport.enums;

public enum JobStatusEnum {
    READY_FOR_PROCESSING("Ready_for_Processing"),
    PROCESSED("Processed");

    private final String key;

    JobStatusEnum(final String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}
