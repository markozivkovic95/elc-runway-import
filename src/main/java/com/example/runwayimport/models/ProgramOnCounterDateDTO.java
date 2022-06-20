package com.example.runwayimport.models;

import java.util.Objects;

import com.example.runwayimport.models.constants.FieldNameConstants;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProgramOnCounterDateDTO {

    @JsonProperty(FieldNameConstants.REGION)
    private String region;

    @JsonProperty(FieldNameConstants.REGIONAL_ON_COUNTER_DATE)
    private String regionalOnCounterDate;

    @JsonProperty(FieldNameConstants.AFFILIATE)
    private String affiliate;

    @JsonProperty(FieldNameConstants.AFFILIATE_ON_COUNTER_DATE)
    private String affiliateOnCounterDate;

    public ProgramOnCounterDateDTO() {
    }

    public ProgramOnCounterDateDTO(final String region, final String regionalOnCounterDate, 
            final String affiliate, final String affiliateOnCounterDate) {
        this.region = region;
        this.regionalOnCounterDate = regionalOnCounterDate;
        this.affiliate = affiliate;
        this.affiliateOnCounterDate = affiliateOnCounterDate;
    }

    public String getRegion() {
        return this.region;
    }

    public ProgramOnCounterDateDTO setRegion(final String region) {
        this.region = region;
        return this;
    }

    public String getRegionalOnCounterDate() {
        return this.regionalOnCounterDate;
    }

    public ProgramOnCounterDateDTO setRegionalOnCounterDate(final String regionalOnCounterDate) {
        this.regionalOnCounterDate = regionalOnCounterDate;
        return this;
    }

    public String getAffiliate() {
        return this.affiliate;
    }

    public ProgramOnCounterDateDTO setAffiliate(final String affiliate) {
        this.affiliate = affiliate;
        return this;
    }

    public String getAffiliateOnCounterDate() {
        return this.affiliateOnCounterDate;
    }

    public ProgramOnCounterDateDTO setAffiliateOnCounterDate(final String affiliateOnCounterDate) {
        this.affiliateOnCounterDate = affiliateOnCounterDate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProgramOnCounterDateDTO)) {
            return false;
        }
        ProgramOnCounterDateDTO programOnCounterDateDTO = (ProgramOnCounterDateDTO) o;
        return Objects.equals(region, programOnCounterDateDTO.region) &&
                Objects.equals(regionalOnCounterDate, programOnCounterDateDTO.regionalOnCounterDate) &&
                Objects.equals(affiliate, programOnCounterDateDTO.affiliate) &&
                Objects.equals(affiliateOnCounterDate, programOnCounterDateDTO.affiliateOnCounterDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(region, regionalOnCounterDate, affiliate, affiliateOnCounterDate);
    }

    @Override
    public String toString() {
        return "{" +
            " region='" + getRegion() + "'" +
            ", regionalOnCounterDate='" + getRegionalOnCounterDate() + "'" +
            ", affiliate='" + getAffiliate() + "'" +
            ", affiliateOnCounterDate='" + getAffiliateOnCounterDate() + "'" +
            "}";
    }    
    
}
