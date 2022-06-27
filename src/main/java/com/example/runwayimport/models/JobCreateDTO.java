package com.example.runwayimport.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JobCreateDTO {
    
    private Integer dseObjectTypeId;
    private Integer workflowTypeId;
    private String name;
    private String parentJobId;

    public JobCreateDTO() {
    }

    public JobCreateDTO(final Integer dseObjectTypeId, final Integer workflowTypeId, final String name,
            final String parentJobId) {
        this.dseObjectTypeId = dseObjectTypeId;
        this.workflowTypeId = workflowTypeId;
        this.name = name;
        this.parentJobId = parentJobId;
    }

    public Integer getDseObjectTypeId() {
        return this.dseObjectTypeId;
    }

    public JobCreateDTO setDseObjectTypeId(final Integer dseObjectTypeId) {
        this.dseObjectTypeId = dseObjectTypeId;
        return this;
    }

    public Integer getWorkflowTypeId() {
        return this.workflowTypeId;
    }

    public JobCreateDTO setWorkflowTypeId(final Integer workflowTypeId) {
        this.workflowTypeId = workflowTypeId;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public JobCreateDTO setName(final String name) {
        this.name = name;
        return this;
    }

    public String getParentJobId() {
        return this.parentJobId;
    }

    public JobCreateDTO setParentJobId(final String parentJobId) {
        this.parentJobId = parentJobId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof JobCreateDTO)) {
            return false;
        }
        JobCreateDTO jobCreateDTO = (JobCreateDTO) o;
        return Objects.equals(dseObjectTypeId, jobCreateDTO.dseObjectTypeId) &&
                Objects.equals(workflowTypeId, jobCreateDTO.workflowTypeId) &&
                Objects.equals(name, jobCreateDTO.name) &&
                Objects.equals(parentJobId, jobCreateDTO.parentJobId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dseObjectTypeId, workflowTypeId, name, parentJobId);
    }

    @Override
    public String toString() {
        return "{" +
            " dseObjectTypeId='" + getDseObjectTypeId() + "'" +
            ", workflowTypeId='" + getWorkflowTypeId() + "'" +
            ", name='" + getName() + "'" +
            ", parentJobId='" + getParentJobId() + "'" +
            "}";
    }

}
