package com.example.runwayimport.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomValueDTO {
    
    private String technicalName;
    private String inheritFromParent;
    private String value;

    public CustomValueDTO() {

    }

    public CustomValueDTO(final String technicalName, final String inheritFromParent, final String value) {
        this.technicalName = technicalName;
        this.inheritFromParent = inheritFromParent;
        this.value = value;
    }

    public String getTechnicalName() {
        return this.technicalName;
    }

    public CustomValueDTO setTechnicalName(final String technicalName) {
        this.technicalName = technicalName;
        return this;
    }

    public String getInheritFromParent() {
        return this.inheritFromParent;
    }

    public CustomValueDTO setInheritFromParent(final String inheritFromParent) {
        this.inheritFromParent = inheritFromParent;
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
        return Objects.equals(technicalName, customValueDTO.technicalName) &&
                Objects.equals(inheritFromParent, customValueDTO.inheritFromParent) &&
                Objects.equals(value, customValueDTO.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(technicalName, inheritFromParent, value);
    }

    @Override
    public String toString() {
        return "{" +
            " technicalName='" + getTechnicalName() + "'" +
            ", inheritFromParent='" + getInheritFromParent() + "'" +
            ", value='" + getValue() + "'" +
            "}";
    }    

}
