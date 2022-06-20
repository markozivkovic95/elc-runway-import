package com.example.runwayimport.models;

import java.util.Objects;

import com.example.runwayimport.models.constants.FieldNameConstants;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductModel {

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

    public ProductModel() {

    }

    public ProductModel(final String productName, final String productCode, final String productLine,
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

    public ProductModel setProductName(final String productName) {
        this.productName = productName;
        return this;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public ProductModel setProductCode(final String productCode) {
        this.productCode = productCode;
        return this;
    }

    public String getProductLine() {
        return this.productLine;
    }

    public ProductModel setProductLine(final String productLine) {
        this.productLine = productLine;
        return this;
    }

    public String getProductRole() {
        return this.productRole;
    }

    public ProductModel setProductRole(final String productRole) {
        this.productRole = productRole;
        return this;
    }

    public String getMajorCategory() {
        return this.majorCategory;
    }

    public ProductModel setMajorCategory(final String majorCategory) {
        this.majorCategory = majorCategory;
        return this;
    }

    public String getApplication() {
        return this.application;
    }

    public ProductModel setApplication(final String application) {
        this.application = application;
        return this;
    }

    public String getCategory() {
        return this.category;
    }

    public ProductModel setCategory(final String category) {
        this.category = category;
        return this;
    }

    public String getSubCategory() {
        return this.subCategory;
    }

    public ProductModel setSubCategory(final String subCategory) {
        this.subCategory = subCategory;
        return this;
    }

    public String getDemandType() {
        return this.demandType;
    }

    public ProductModel setDemandType(final String demandType) {
        this.demandType = demandType;
        return this;
    }

    public String getSaleable() {
        return this.saleable;
    }

    public ProductModel setSaleable(final String saleable) {
        this.saleable = saleable;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProductModel)) {
            return false;
        }
        ProductModel product = (ProductModel) o;
        return Objects.equals(productName, product.productName) &&
                Objects.equals(productCode, product.productCode) &&
                Objects.equals(productLine, product.productLine) &&
                Objects.equals(productRole, product.productRole) &&
                Objects.equals(majorCategory, product.majorCategory) &&
                Objects.equals(application, product.application) &&
                Objects.equals(category, product.category) &&
                Objects.equals(subCategory, product.subCategory) &&
                Objects.equals(demandType, product.demandType) &&
                Objects.equals(saleable, product.saleable);
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
