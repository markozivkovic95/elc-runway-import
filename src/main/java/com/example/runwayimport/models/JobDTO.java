package com.example.runwayimport.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JobDTO {
    
    private Integer instanceId;
    private Integer l10nLocaleId;
    private Integer workflowObjectId;
    private String name;
    private String extendedName;
    private String state;
    private Integer ordinalNumber;
    private Integer typeId;
    private AccountDTO creator;
    private JobAssignmentDTO assignment;
    private Integer workflowTypeId;
    private Integer currentStepTemplateId;
    private Map<String, CustomValueDTO> values = new HashMap<>();

    public JobDTO() {

    }

    public JobDTO(final Integer instanceId, final Integer l10nLocaleId, final Integer workflowObjectId,
            final String name, final String extendedName, final String state, final Integer ordinalNumber,
            final Integer typeId, final AccountDTO creator, final JobAssignmentDTO assignment, 
            final Integer workflowTypeId, final Integer currentStepTemplateId, final Map<String,CustomValueDTO> values) {
        
        this.instanceId = instanceId;
        this.l10nLocaleId = l10nLocaleId;
        this.workflowObjectId = workflowObjectId;
        this.name = name;
        this.extendedName = extendedName;
        this.state = state;
        this.ordinalNumber = ordinalNumber;
        this.typeId = typeId;
        this.creator = creator;
        this.assignment = assignment;
        this.workflowTypeId = workflowTypeId;
        this.currentStepTemplateId = currentStepTemplateId;
        this.values = values;
    }

    public Integer getInstanceId() {
        return this.instanceId;
    }

    public JobDTO setInstanceId(final Integer instanceId) {
        this.instanceId = instanceId;
        return this;
    }

    public Integer getL10nLocaleId() {
        return this.l10nLocaleId;
    }

    public JobDTO setL10nLocaleId(final Integer l10nLocaleId) {
        this.l10nLocaleId = l10nLocaleId;
        return this;
    }

    public Integer getWorkflowObjectId() {
        return this.workflowObjectId;
    }

    public JobDTO setWorkflowObjectId(final Integer workflowObjectId) {
        this.workflowObjectId = workflowObjectId;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public JobDTO setName(final String name) {
        this.name = name;
        return this;
    }

    public String getExtendedName() {
        return this.extendedName;
    }

    public JobDTO setExtendedName(final String extendedName) {
        this.extendedName = extendedName;
        return this;
    }

    public String getState() {
        return this.state;
    }

    public JobDTO setState(final String state) {
        this.state = state;
        return this;
    }

    public Integer getOrdinalNumber() {
        return this.ordinalNumber;
    }

    public JobDTO setOrdinalNumber(final Integer ordinalNumber) {
        this.ordinalNumber = ordinalNumber;
        return this;
    }

    public Integer getTypeId() {
        return this.typeId;
    }

    public JobDTO setTypeId(final Integer typeId) {
        this.typeId = typeId;
        return this;
    }

    public AccountDTO getCreator() {
        return this.creator;
    }

    public JobDTO setCreator(final AccountDTO creator) {
        this.creator = creator;
        return this;
    }

    public JobAssignmentDTO getAssignment() {
        return this.assignment;
    }

    public JobDTO setAssignment(final JobAssignmentDTO assignment) {
        this.assignment = assignment;
        return this;
    }

    public Integer getWorkflowTypeId() {
        return this.workflowTypeId;
    }

    public JobDTO setWorkflowTypeId(final Integer workflowTypeId) {
        this.workflowTypeId = workflowTypeId;
        return this;
    }

    public Integer getCurrentStepTemplateId() {
        return this.currentStepTemplateId;
    }

    public JobDTO setCurrentStepTemplateId(final Integer currentStepTemplateId) {
        this.currentStepTemplateId = currentStepTemplateId;
        return this;
    }

    public Map<String,CustomValueDTO> getValues() {
        return this.values;
    }

    public JobDTO setValues(final Map<String,CustomValueDTO> values) {
        this.values = values;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof JobDTO)) {
            return false;
        }
        JobDTO jobDTO = (JobDTO) o;
        return Objects.equals(instanceId, jobDTO.instanceId) &&
                Objects.equals(l10nLocaleId, jobDTO.l10nLocaleId) &&
                Objects.equals(workflowObjectId, jobDTO.workflowObjectId) &&
                Objects.equals(name, jobDTO.name) &&
                Objects.equals(extendedName, jobDTO.extendedName) &&
                Objects.equals(state, jobDTO.state) &&
                Objects.equals(ordinalNumber, jobDTO.ordinalNumber) &&
                Objects.equals(typeId, jobDTO.typeId) &&
                Objects.equals(creator, jobDTO.creator) &&
                Objects.equals(assignment, jobDTO.assignment) &&
                Objects.equals(workflowTypeId, jobDTO.workflowTypeId) &&
                Objects.equals(currentStepTemplateId, jobDTO.currentStepTemplateId) &&
                Objects.equals(values, jobDTO.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            instanceId, l10nLocaleId, workflowObjectId, name, extendedName, state,
            ordinalNumber, typeId, creator, assignment, workflowTypeId, currentStepTemplateId,
            values
        );
    }

    @Override
    public String toString() {
        return "{" +
            " instanceId='" + getInstanceId() + "'" +
            ", l10nLocaleId='" + getL10nLocaleId() + "'" +
            ", workflowObjectId='" + getWorkflowObjectId() + "'" +
            ", name='" + getName() + "'" +
            ", extendedName='" + getExtendedName() + "'" +
            ", state='" + getState() + "'" +
            ", ordinalNumber='" + getOrdinalNumber() + "'" +
            ", typeId='" + getTypeId() + "'" +
            ", creator='" + getCreator() + "'" +
            ", assignment='" + getAssignment() + "'" +
            ", workflowTypeId='" + getWorkflowTypeId() + "'" +
            ", currentStepTemplateId='" + getCurrentStepTemplateId() + "'" +
            ", values='" + getValues() + "'" +
            "}";
    }

}
