package com.example.runwayimport.models;

import java.util.Objects;

public class JobOverviewRightsDTO {
    
    private Boolean canUndelete;
    private Boolean canEdit;
    private Boolean canDelete;
    private Boolean isPickable;
    private Boolean canDeArchive;

    public JobOverviewRightsDTO() {
    }

    public JobOverviewRightsDTO(final Boolean canUndelete, final Boolean canEdit, final Boolean canDelete,
            final Boolean isPickable, final Boolean canDeArchive) {
        this.canUndelete = canUndelete;
        this.canEdit = canEdit;
        this.canDelete = canDelete;
        this.isPickable = isPickable;
        this.canDeArchive = canDeArchive;
    }

    public Boolean isCanUndelete() {
        return this.canUndelete;
    }

    public Boolean getCanUndelete() {
        return this.canUndelete;
    }

    public JobOverviewRightsDTO setCanUndelete(final Boolean canUndelete) {
        this.canUndelete = canUndelete;
        return this;
    }

    public Boolean isCanEdit() {
        return this.canEdit;
    }

    public Boolean getCanEdit() {
        return this.canEdit;
    }

    public JobOverviewRightsDTO setCanEdit(final Boolean canEdit) {
        this.canEdit = canEdit;
        return this;
    }

    public Boolean isCanDelete() {
        return this.canDelete;
    }

    public Boolean getCanDelete() {
        return this.canDelete;
    }

    public JobOverviewRightsDTO setCanDelete(final Boolean canDelete) {
        this.canDelete = canDelete;
        return this;
    }

    public Boolean isIsPickable() {
        return this.isPickable;
    }

    public Boolean getIsPickable() {
        return this.isPickable;
    }

    public JobOverviewRightsDTO setIsPickable(final Boolean isPickable) {
        this.isPickable = isPickable;
        return this;
    }

    public Boolean isCanDeArchive() {
        return this.canDeArchive;
    }

    public Boolean getCanDeArchive() {
        return this.canDeArchive;
    }

    public JobOverviewRightsDTO setCanDeArchive(final Boolean canDeArchive) {
        this.canDeArchive = canDeArchive;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof JobOverviewRightsDTO)) {
            return false;
        }
        JobOverviewRightsDTO jobPreviewRightsDTO = (JobOverviewRightsDTO) o;
        return Objects.equals(canUndelete, jobPreviewRightsDTO.canUndelete) &&
                Objects.equals(canEdit, jobPreviewRightsDTO.canEdit) &&
                Objects.equals(canDelete, jobPreviewRightsDTO.canDelete) &&
                Objects.equals(isPickable, jobPreviewRightsDTO.isPickable) &&
                Objects.equals(canDeArchive, jobPreviewRightsDTO.canDeArchive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(canUndelete, canEdit, canDelete, isPickable, canDeArchive);
    }

    @Override
    public String toString() {
        return "{" +
            " canUndelete='" + isCanUndelete() + "'" +
            ", canEdit='" + isCanEdit() + "'" +
            ", canDelete='" + isCanDelete() + "'" +
            ", isPickable='" + isIsPickable() + "'" +
            ", canDeArchive='" + isCanDeArchive() + "'" +
            "}";
    }

}
