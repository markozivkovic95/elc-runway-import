package com.example.runwayimport.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JobValuesDTO {
    
    private Map<String, CustomValueDTO> values = new HashMap<>();


    public JobValuesDTO() {
    }

    public JobValuesDTO(final Map<String,CustomValueDTO> values) {
        this.values = values;
    }

    public Map<String,CustomValueDTO> getValues() {
        return this.values;
    }

    public JobValuesDTO setValues(final Map<String,CustomValueDTO> values) {
        this.values = values;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof JobValuesDTO)) {
            return false;
        }
        JobValuesDTO jobValuesDTO = (JobValuesDTO) o;
        return Objects.equals(values, jobValuesDTO.values);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(values);
    }

    @Override
    public String toString() {
        return "{" +
            " values='" + getValues() + "'" +
            "}";
    }

}
