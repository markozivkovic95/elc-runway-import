package com.example.runwayimport.models;

import java.util.Objects;

import com.example.runwayimport.models.constants.FieldNameConstants;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDTO {

    @JsonProperty(FieldNameConstants.PRODUCT_NAME)
    private String productName;

    @JsonProperty(FieldNameConstants.PRODUCT_CODE)
    private String productCode;

    @JsonProperty(FieldNameConstants.PRODUCT_LINE)
    private String productLine;

    @JsonProperty(FieldNameConstants.PRODUCT_ROLE)
    private String productRole;

    @JsonProperty(FieldNameConstants.MAJOR_CATEGORY)
    private String majorCategory;

    @JsonProperty(FieldNameConstants.APPLICATION)
    private String application;

    @JsonProperty(FieldNameConstants.CATEGORY)
    private String category;

    @JsonProperty(FieldNameConstants.SUB_CATEGORY)
    private String subCategory;

    @JsonProperty(FieldNameConstants.DEMAND_TYPE)
    private String demandType;

    @JsonProperty(FieldNameConstants.SALEABLE)
    private String saleable;

    public ProductDTO() {

    }

    public ProductDTO(final String productName, final String productCode, final String productLine,
            final String productRole, final String majorCategory, final String application,
            final String category, final String subCategory, final String demandType, 
            final String saleable) {
        this.productName = productName;
        this.productCode = productCode;
        this.productLine = productLine;
        this.productRole = productRole;
        this.majorCategory = majorCategory;
        this.application = application;
        this.category = category;
        this.subCategory = subCategory;
        this.demandType = demandType;
        this.saleable = saleable;
    }

    public String getProductName() {
        return this.productName;
    }

    public ProductDTO setProductName(final String productName) {
        this.productName = productName;
        return this;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public ProductDTO setProductCode(final String productCode) {
        this.productCode = productCode;
        return this;
    }

    public String getProductLine() {
        return this.productLine;
    }

    public ProductDTO setProductLine(final String productLine) {
        this.productLine = productLine;
        return this;
    }

    public String getProductRole() {
        return this.productRole;
    }

    public ProductDTO setProductRole(final String productRole) {
        this.productRole = productRole;
        return this;
    }

    public String getMajorCategory() {
        return this.majorCategory;
    }

    public ProductDTO setMajorCategory(final String majorCategory) {
        this.majorCategory = majorCategory;
        return this;
    }

    public String getApplication() {
        return this.application;
    }

    public ProductDTO setApplication(final String application) {
        this.application = application;
        return this;
    }

    public String getCategory() {
        return this.category;
    }

    public ProductDTO setCategory(final String category) {
        this.category = category;
        return this;
    }

    public String getSubCategory() {
        return this.subCategory;
    }

    public ProductDTO setSubCategory(final String subCategory) {
        this.subCategory = subCategory;
        return this;
    }

    public String getDemandType() {
        return this.demandType;
    }

    public ProductDTO setDemandType(final String demandType) {
        this.demandType = demandType;
        return this;
    }

    public String getSaleable() {
        return this.saleable;
    }

    public ProductDTO setSaleable(final String saleable) {
        this.saleable = saleable;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProductDTO)) {
            return false;
        }
        ProductDTO productDTO = (ProductDTO) o;
        return Objects.equals(productName, productDTO.productName) &&
                Objects.equals(productCode, productDTO.productCode) &&
                Objects.equals(productLine, productDTO.productLine) &&
                Objects.equals(productRole, productDTO.productRole) &&
                Objects.equals(majorCategory, productDTO.majorCategory) &&
                Objects.equals(application, productDTO.application) &&
                Objects.equals(category, productDTO.category) &&
                Objects.equals(subCategory, productDTO.subCategory) &&
                Objects.equals(demandType, productDTO.demandType) &&
                Objects.equals(saleable, productDTO.saleable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                productName, productCode, productLine, productRole, majorCategory,
                application, category, subCategory, demandType, saleable
        );
    }

    @Override
    public String toString() {
        return "{" +
            " productName='" + getProductName() + "'" +
            ", productCode='" + getProductCode() + "'" +
            ", productLine='" + getProductLine() + "'" +
            ", productRole='" + getProductRole() + "'" +
            ", majorCategory='" + getMajorCategory() + "'" +
            ", application='" + getApplication() + "'" +
            ", category='" + getCategory() + "'" +
            ", subCategory='" + getSubCategory() + "'" +
            ", demandType='" + getDemandType() + "'" +
            ", saleable='" + getSaleable() + "'" +
            "}";
    }
    
}
