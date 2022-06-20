package com.example.runwayimport.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JobOverviewDTO {
    
    private Integer creatorId;
    private Integer jobDescriptionId;
    private Boolean userHasOwnerRights;
    private String currentStepStatus;
    private Boolean unassignedDseObject;
    private Integer jobId;
    private Integer localeId;
    private Integer subjobs;
    private Boolean isBpmn;
    private Integer workFlowObjectId;
    private List<JobOverviewStepDTO> currentSteps = new ArrayList<>();
    private JobOverviewRightsDTO rights;

    public JobOverviewDTO() {
        
    }

    public JobOverviewDTO(final Integer creatorId, final Integer jobDescriptionId, final Boolean userHasOwnerRights,
            final String currentStepStatus, final Boolean unassignedDseObject, final Integer jobId, 
            final Integer localeId, final Integer subjobs, final Boolean isBpmn, final Integer workFlowObjectId,
            final List<JobOverviewStepDTO> currentSteps, final JobOverviewRightsDTO rights) {

        this.creatorId = creatorId;
        this.jobDescriptionId = jobDescriptionId;
        this.userHasOwnerRights = userHasOwnerRights;
        this.currentStepStatus = currentStepStatus;
        this.unassignedDseObject = unassignedDseObject;
        this.jobId = jobId;
        this.localeId = localeId;
        this.subjobs = subjobs;
        this.isBpmn = isBpmn;
        this.workFlowObjectId = workFlowObjectId;
        this.currentSteps = currentSteps;
        this.rights = rights;
    }

    public Integer getCreatorId() {
        return this.creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Integer getJobDescriptionId() {
        return this.jobDescriptionId;
    }

    public void setJobDescriptionId(Integer jobDescriptionId) {
        this.jobDescriptionId = jobDescriptionId;
    }

    public Boolean isUserHasOwnerRights() {
        return this.userHasOwnerRights;
    }

    public Boolean getUserHasOwnerRights() {
        return this.userHasOwnerRights;
    }

    public void setUserHasOwnerRights(Boolean userHasOwnerRights) {
        this.userHasOwnerRights = userHasOwnerRights;
    }

    public String getCurrentStepStatus() {
        return this.currentStepStatus;
    }

    public void setCurrentStepStatus(String currentStepStatus) {
        this.currentStepStatus = currentStepStatus;
    }

    public Boolean isUnassignedDseObject() {
        return this.unassignedDseObject;
    }

    public Boolean getUnassignedDseObject() {
        return this.unassignedDseObject;
    }

    public void setUnassignedDseObject(Boolean unassignedDseObject) {
        this.unassignedDseObject = unassignedDseObject;
    }

    public Integer getJobId() {
        return this.jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getLocaleId() {
        return this.localeId;
    }

    public void setLocaleId(Integer localeId) {
        this.localeId = localeId;
    }

    public Integer getSubjobs() {
        return this.subjobs;
    }

    public void setSubjobs(Integer subjobs) {
        this.subjobs = subjobs;
    }

    public Boolean isIsBpmn() {
        return this.isBpmn;
    }

    public Boolean getIsBpmn() {
        return this.isBpmn;
    }

    public void setIsBpmn(Boolean isBpmn) {
        this.isBpmn = isBpmn;
    }

    public Integer getWorkFlowObjectId() {
        return this.workFlowObjectId;
    }

    public void setWorkFlowObjectId(Integer workFlowObjectId) {
        this.workFlowObjectId = workFlowObjectId;
    }

    public List<JobOverviewStepDTO> getCurrentSteps() {
        return this.currentSteps;
    }

    public void setCurrentSteps(List<JobOverviewStepDTO> currentSteps) {
        this.currentSteps = currentSteps;
    }

    public JobOverviewRightsDTO getRights() {
        return this.rights;
    }

    public void setRights(JobOverviewRightsDTO rights) {
        this.rights = rights;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof JobOverviewDTO)) {
            return false;
        }
        JobOverviewDTO jobPreviewDTO = (JobOverviewDTO) o;
        return Objects.equals(creatorId, jobPreviewDTO.creatorId) &&
                Objects.equals(jobDescriptionId, jobPreviewDTO.jobDescriptionId) &&
                Objects.equals(userHasOwnerRights, jobPreviewDTO.userHasOwnerRights) &&
                Objects.equals(currentStepStatus, jobPreviewDTO.currentStepStatus) &&
                Objects.equals(unassignedDseObject, jobPreviewDTO.unassignedDseObject) &&
                Objects.equals(jobId, jobPreviewDTO.jobId) &&
                Objects.equals(localeId, jobPreviewDTO.localeId) &&
                Objects.equals(subjobs, jobPreviewDTO.subjobs) &&
                Objects.equals(isBpmn, jobPreviewDTO.isBpmn) &&
                Objects.equals(workFlowObjectId, jobPreviewDTO.workFlowObjectId) &&
                Objects.equals(currentSteps, jobPreviewDTO.currentSteps) &&
                Objects.equals(rights, jobPreviewDTO.rights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            creatorId, jobDescriptionId, userHasOwnerRights, currentStepStatus, unassignedDseObject,
            jobId, localeId, subjobs, isBpmn, workFlowObjectId, currentSteps, rights
        );
    }

    @Override
    public String toString() {
        return "{" +
            " creatorId='" + getCreatorId() + "'" +
            ", jobDescriptionId='" + getJobDescriptionId() + "'" +
            ", userHasOwnerRights='" + isUserHasOwnerRights() + "'" +
            ", currentStepStatus='" + getCurrentStepStatus() + "'" +
            ", unassignedDseObject='" + isUnassignedDseObject() + "'" +
            ", jobId='" + getJobId() + "'" +
            ", localeId='" + getLocaleId() + "'" +
            ", subjobs='" + getSubjobs() + "'" +
            ", isBpmn='" + isIsBpmn() + "'" +
            ", workFlowObjectId='" + getWorkFlowObjectId() + "'" +
            ", currentSteps='" + getCurrentSteps() + "'" +
            ", rights='" + getRights() + "'" +
            "}";
    }

}
