package com.example.runwayimport.models;

import java.util.Objects;

public class CustomValueDTO {
    
    private String inheritFromParent;
    private String inheritedValue;
    private String displayValue;
    private String value;

    public CustomValueDTO() {

    }

    public CustomValueDTO(final String inheritFromParent, final String inheritedValue,
            final String displayValue, final String value) {
        this.inheritFromParent = inheritFromParent;
        this.inheritedValue = inheritedValue;
        this.displayValue = displayValue;
        this.value = value;
    }

    public String getInheritFromParent() {
        return this.inheritFromParent;
    }

    public CustomValueDTO setInheritFromParent(final String inheritFromParent) {
        this.inheritFromParent = inheritFromParent;
        return this;
    }

    public String getInheritedValue() {
        return this.inheritedValue;
    }

    public CustomValueDTO setInheritedValue(final String inheritedValue) {
        this.inheritedValue = inheritedValue;
        return this;
    }

    public String getDisplayValue() {
        return this.displayValue;
    }

    public CustomValueDTO setDisplayValue(final String displayValue) {
        this.displayValue = displayValue;
        return this;
    }

    public String getValue() {
        return this.value;
    }

    public CustomValueDTO setValue(final String value) {
        this.value = value;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CustomValueDTO)) {
            return false;
        }
        CustomValueDTO customValueDTO = (CustomValueDTO) o;
        return Objects.equals(inheritFromParent, customValueDTO.inheritFromParent) &&
                Objects.equals(inheritedValue, customValueDTO.inheritedValue) &&
                Objects.equals(displayValue, customValueDTO.displayValue) &&
                Objects.equals(value, customValueDTO.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inheritFromParent, inheritedValue, displayValue, value);
    }

    @Override
    public String toString() {
        return "{" +
            " inheritFromParent='" + getInheritFromParent() + "'" +
            ", inheritedValue='" + getInheritedValue() + "'" +
            ", displayValue='" + getDisplayValue() + "'" +
            ", value='" + getValue() + "'" +
            "}";
    }

}
