package com.example.runwayimport.models;

import java.util.Objects;

import com.example.runwayimport.models.constants.FieldNameConstants;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProgramOnCounterDate {

    @JsonProperty(FieldNameConstants.REGION)
    private String region;

    @JsonProperty(FieldNameConstants.REGIONAL_ON_COUNTER_DATE)
    private String regionalOnCounterDate;

    @JsonProperty(FieldNameConstants.AFFILIATE)
    private String affiliate;

    @JsonProperty(FieldNameConstants.AFFILIATE_ON_COUNTER_DATE)
    private String affiliateOnCounterDate;

    public ProgramOnCounterDate() {
    }

    public ProgramOnCounterDate(final String region, final String regionalOnCounterDate, 
            final String affiliate, final String affiliateOnCounterDate) {
        this.region = region;
        this.regionalOnCounterDate = regionalOnCounterDate;
        this.affiliate = affiliate;
        this.affiliateOnCounterDate = affiliateOnCounterDate;
    }

    public String getRegion() {
        return this.region;
    }

    public ProgramOnCounterDate setRegion(final String region) {
        this.region = region;
        return this;
    }

    public String getRegionalOnCounterDate() {
        return this.regionalOnCounterDate;
    }

    public ProgramOnCounterDate setRegionalOnCounterDate(final String regionalOnCounterDate) {
        this.regionalOnCounterDate = regionalOnCounterDate;
        return this;
    }

    public String getAffiliate() {
        return this.affiliate;
    }

    public ProgramOnCounterDate setAffiliate(final String affiliate) {
        this.affiliate = affiliate;
        return this;
    }

    public String getAffiliateOnCounterDate() {
        return this.affiliateOnCounterDate;
    }

    public ProgramOnCounterDate setAffiliateOnCounterDate(final String affiliateOnCounterDate) {
        this.affiliateOnCounterDate = affiliateOnCounterDate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProgramOnCounterDate)) {
            return false;
        }
        ProgramOnCounterDate programOnCounterDate = (ProgramOnCounterDate) o;
        return Objects.equals(region, programOnCounterDate.region) &&
                Objects.equals(regionalOnCounterDate, programOnCounterDate.regionalOnCounterDate) &&
                Objects.equals(affiliate, programOnCounterDate.affiliate) &&
                Objects.equals(affiliateOnCounterDate, programOnCounterDate.affiliateOnCounterDate);
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
