package com.example.runwayimport.models;

import java.util.Objects;

public class SearchParamsDTO {
    
    private Integer moduleId;
    private String filterId;

    public SearchParamsDTO() {
    }

    public SearchParamsDTO(final Integer moduleId, final String filterId) {
        this.moduleId = moduleId;
        this.filterId = filterId;
    }

    public Integer getModuleId() {
        return this.moduleId;
    }

    public SearchParamsDTO setModuleId(final Integer moduleId) {
        this.moduleId = moduleId;
        return this;
    }

    public String getFilterId() {
        return this.filterId;
    }

    public SearchParamsDTO setFilterId(final String filterId) {
        this.filterId = filterId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SearchParamsDTO)) {
            return false;
        }
        SearchParamsDTO searchParamsDTO = (SearchParamsDTO) o;
        return Objects.equals(moduleId, searchParamsDTO.moduleId) &&
                Objects.equals(filterId, searchParamsDTO.filterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moduleId, filterId);
    }

    @Override
    public String toString() {
        return "{" +
            " moduleId='" + getModuleId() + "'" +
            ", filterId='" + getFilterId() + "'" +
            "}";
    }

}
