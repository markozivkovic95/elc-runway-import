package com.example.runwayimport.models;

import java.util.Objects;

public class JobOverviewStepDTO {
    
    private String stepName;
    private Integer stepNumber;

    public JobOverviewStepDTO() {

    }

    public JobOverviewStepDTO(final String stepName, final Integer stepNumber) {
        this.stepName = stepName;
        this.stepNumber = stepNumber;
    }

    public String getStepName() {
        return this.stepName;
    }

    public JobOverviewStepDTO setStepName(final String stepName) {
        this.stepName = stepName;
        return this;
    }

    public Integer getStepNumber() {
        return this.stepNumber;
    }

    public JobOverviewStepDTO setStepNumber(final Integer stepNumber) {
        this.stepNumber = stepNumber;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof JobOverviewStepDTO)) {
            return false;
        }
        JobOverviewStepDTO jobPreviewStepDTO = (JobOverviewStepDTO) o;
        return Objects.equals(stepName, jobPreviewStepDTO.stepName) &&
                Objects.equals(stepNumber, jobPreviewStepDTO.stepNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stepName, stepNumber);
    }

    @Override
    public String toString() {
        return "{" +
            " stepName='" + getStepName() + "'" +
            ", stepNumber='" + getStepNumber() + "'" +
            "}";
    }

}
