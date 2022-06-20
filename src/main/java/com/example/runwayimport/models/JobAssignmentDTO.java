package com.example.runwayimport.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JobAssignmentDTO {
    
    private List<AccountDTO> assignees = new ArrayList<>();

    public JobAssignmentDTO() {

    }

    public JobAssignmentDTO(final List<AccountDTO> assignees) {
        this.assignees = assignees;
    }

    public List<AccountDTO> getAssignees() {
        return this.assignees;
    }

    public JobAssignmentDTO setAssignees(final List<AccountDTO> assignees) {
        this.assignees = assignees;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof JobAssignmentDTO)) {
            return false;
        }
        JobAssignmentDTO jobAssignmentTO = (JobAssignmentDTO) o;
        return Objects.equals(assignees, jobAssignmentTO.assignees);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(assignees);
    }

    @Override
    public String toString() {
        return "{" +
            " assignees='" + getAssignees() + "'" +
            "}";
    }

}
