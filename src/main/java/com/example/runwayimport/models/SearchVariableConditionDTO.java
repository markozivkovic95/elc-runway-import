package com.example.runwayimport.models;

import java.util.Objects;

public class SearchVariableConditionDTO {
    
    private String value;
    private String name;
    private String operator;
    private String cmpCondition;

    public SearchVariableConditionDTO() {

    }

    public SearchVariableConditionDTO(final String value, final String name, 
            final String operator, final String cmpCondition) {
        this.value = value;
        this.name = name;
        this.operator = operator;
        this.cmpCondition = cmpCondition;
    }

    public String getValue() {
        return this.value;
    }

    public SearchVariableConditionDTO setValue(final String value) {
        this.value = value;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public SearchVariableConditionDTO setName(final String name) {
        this.name = name;
        return this;
    }

    public String getOperator() {
        return this.operator;
    }

    public SearchVariableConditionDTO setOperator(final String operator) {
        this.operator = operator;
        return this;
    }

    public String getCmpCondition() {
        return this.cmpCondition;
    }

    public SearchVariableConditionDTO setCmpCondition(final String cmpCondition) {
        this.cmpCondition = cmpCondition;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SearchVariableConditionDTO)) {
            return false;
        }
        SearchVariableConditionDTO searchVariableConditionDTO = (SearchVariableConditionDTO) o;
        return Objects.equals(value, searchVariableConditionDTO.value) &&
                Objects.equals(name, searchVariableConditionDTO.name) &&
                Objects.equals(operator, searchVariableConditionDTO.operator) &&
                Objects.equals(cmpCondition, searchVariableConditionDTO.cmpCondition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, name, operator, cmpCondition);
    }

    @Override
    public String toString() {
        return "{" +
            " value='" + getValue() + "'" +
            ", name='" + getName() + "'" +
            ", operator='" + getOperator() + "'" +
            ", cmpCondition='" + getCmpCondition() + "'" +
            "}";
    }

}
