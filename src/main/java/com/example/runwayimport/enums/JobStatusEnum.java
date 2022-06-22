package com.example.runwayimport.enums;

public enum JobStatusEnum {
    READY_FOR_PROCESSING("Ready for Processing"),
    PROCESSED("Processed");

    private final String key;

    JobStatusEnum(final String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}
