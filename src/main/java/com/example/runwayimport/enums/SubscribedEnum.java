package com.example.runwayimport.enums;

public enum SubscribedEnum {
    Y("1"),
    N("2");

    private final String key;

    SubscribedEnum(final String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}
