package com.example.runwayimport.models;

import java.util.Objects;

public class SearchParamsDTO {
    
    private String filterId;

    public SearchParamsDTO() {
    }

    public SearchParamsDTO(final String filterId) {
        this.filterId = filterId;
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
        return Objects.equals(filterId, searchParamsDTO.filterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filterId);
    }

    @Override
    public String toString() {
        return "{" +
            " filterId='" + getFilterId() + "'" +
            "}";
    }

}
