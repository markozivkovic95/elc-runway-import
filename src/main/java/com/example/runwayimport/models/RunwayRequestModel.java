package com.example.runwayimport.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.example.runwayimport.models.constants.FieldNameConstants;

public class RunwayRequestModel {
    
    @JsonProperty(FieldNameConstants.PROGRAM_ID)
    private String programId;

    @JsonProperty(value = FieldNameConstants.PROGRAM_NAME, required = true)
    private String programName;

    @JsonProperty(FieldNameConstants.PROGRAM_BRAND)
    private String programBrand;

    @JsonProperty(FieldNameConstants.PRODUCT_LINE)
    private String productLine;

    @JsonProperty(FieldNameConstants.PROGRAM_STATUS)
    private String programStatus;

    @JsonProperty(value = FieldNameConstants.PROGRAM_START_DATE, required = true)
    private String programStartDate;

    @JsonProperty(value = FieldNameConstants.PROGRAM_END_DATE, required = true)
    private String programEndDate;

    @JsonProperty(FieldNameConstants.PROGRAM_TYPE)
    private String programType;

    @JsonProperty(FieldNameConstants.PRIORITY)
    private String priority;

    @JsonProperty(FieldNameConstants.PRODUCT_ROLE)
    private String productRole;

    @JsonProperty(FieldNameConstants.MAJOR_INVENTORY_TYPE)
    private String majorInventoryType;

    @JsonProperty(FieldNameConstants.INVENTORY_TYPE)
    private String inventoryType;

    @JsonProperty(FieldNameConstants.MAJOR_CATEGORY)
    private String majorCategory;

    @JsonProperty(FieldNameConstants.APPLICATION)
    private String application;

    @JsonProperty(FieldNameConstants.CATEGORY)
    private String category;

    @JsonProperty(FieldNameConstants.SUB_CATEGORY)
    private String subCategory;

    @JsonProperty(value = FieldNameConstants.SUB_CATEGORY_PRIORITY, required = true)
    private String subCategoryPriority;

    @JsonProperty(FieldNameConstants.SEASON)
    private String season;

    @JsonProperty(FieldNameConstants.QUARTER)
    private String quarter;

    @JsonProperty(FieldNameConstants.SOURCE_FACTORY_SHIP_DATE)
    private String sourceFactoryShipDate;

    @JsonProperty(FieldNameConstants.ON_COUNTER_DATES)
    private List<ProgramOnCounterDate> programOnCounterDates = new ArrayList<>();

    @JsonProperty(FieldNameConstants.PRODUCTS)
    private List<ProductModel> products = new ArrayList<>();

    public RunwayRequestModel() {

    }

    public RunwayRequestModel(final String programId, final String programName, final String programBrand,
            final String productLine, final String programStatus, final String programStartDate, 
            final String programEndDate, final String programType, final String priority, final String productRole,
            final String majorInventoryType, final String inventoryType, final String majorCategory,
            final String application, final String category, final String subCategory, final String subCategoryPriority,
            final String season, final String quarter, final String sourceFactoryShipDate, 
            final List<ProgramOnCounterDate> programOnCounterDates, final List<ProductModel> products) {

        this.programId = programId;
        this.programName = programName;
        this.programBrand = programBrand;
        this.productLine = productLine;
        this.programStatus = programStatus;
        this.programStartDate = programStartDate;
        this.programEndDate = programEndDate;
        this.programType = programType;
        this.priority = priority;
        this.productRole = productRole;
        this.majorInventoryType = majorInventoryType;
        this.inventoryType = inventoryType;
        this.majorCategory = majorCategory;
        this.application = application;
        this.category = category;
        this.subCategory = subCategory;
        this.subCategoryPriority = subCategoryPriority;
        this.season = season;
        this.quarter = quarter;
        this.sourceFactoryShipDate = sourceFactoryShipDate;
        this.programOnCounterDates = programOnCounterDates;
        this.products = products;
    }

    public String getProgramId() {
        return this.programId;
    }

    public RunwayRequestModel setProgramId(final String programId) {
        this.programId = programId;
        return this;
    }

    public String getProgramName() {
        return this.programName;
    }

    public RunwayRequestModel setProgramName(final String programName) {
        this.programName = programName;
        return this;
    }

    public String getProgramBrand() {
        return this.programBrand;
    }

    public RunwayRequestModel setProgramBrand(final String programBrand) {
        this.programBrand = programBrand;
        return this;
    }

    public String getProductLine() {
        return this.productLine;
    }

    public RunwayRequestModel setProductLine(final String productLine) {
        this.productLine = productLine;
        return this;
    }

    public String getProgramStatus() {
        return this.programStatus;
    }

    public RunwayRequestModel setProgramStatus(final String programStatus) {
        this.programStatus = programStatus;
        return this;
    }

    public String getProgramStartDate() {
        return this.programStartDate;
    }

    public RunwayRequestModel setProgramStartDate(final String programStartDate) {
        this.programStartDate = programStartDate;
        return this;
    }

    public String getProgramEndDate() {
        return this.programEndDate;
    }

    public RunwayRequestModel setProgramEndDate(final String programEndDate) {
        this.programEndDate = programEndDate;
        return this;
    }

    public String getProgramType() {
        return this.programType;
    }

    public RunwayRequestModel setProgramType(final String programType) {
        this.programType = programType;
        return this;
    }

    public String getPriority() {
        return this.priority;
    }

    public RunwayRequestModel setPriority(final String priority) {
        this.priority = priority;
        return this;
    }

    public String getProductRole() {
        return this.productRole;
    }

    public RunwayRequestModel setProductRole(final String productRole) {
        this.productRole = productRole;
        return this;
    }

    public String getMajorInventoryType() {
        return this.majorInventoryType;
    }

    public RunwayRequestModel setMajorInventoryType(final String majorInventoryType) {
        this.majorInventoryType = majorInventoryType;
        return this;
    }

    public String getInventoryType() {
        return this.inventoryType;
    }

    public RunwayRequestModel setInventoryType(final String inventoryType) {
        this.inventoryType = inventoryType;
        return this;
    }

    public String getMajorCategory() {
        return this.majorCategory;
    }

    public RunwayRequestModel setMajorCategory(final String majorCategory) {
        this.majorCategory = majorCategory;
        return this;
    }

    public String getApplication() {
        return this.application;
    }

    public RunwayRequestModel setApplication(final String application) {
        this.application = application;
        return this;
    }

    public String getCategory() {
        return this.category;
    }

    public RunwayRequestModel setCategory(final String category) {
        this.category = category;
        return this;
    }

    public String getSubCategory() {
        return this.subCategory;
    }

    public RunwayRequestModel setSubCategory(final String subCategory) {
        this.subCategory = subCategory;
        return this;
    }

    public String getSubCategoryPriority() {
        return this.subCategoryPriority;
    }

    public RunwayRequestModel setSubCategoryPriority(final String subCategoryPriority) {
        this.subCategoryPriority = subCategoryPriority;
        return this;
    }

    public String getSeason() {
        return this.season;
    }

    public RunwayRequestModel setSeason(final String season) {
        this.season = season;
        return this;
    }

    public String getQuarter() {
        return this.quarter;
    }

    public RunwayRequestModel setQuarter(final String quarter) {
        this.quarter = quarter;
        return this;
    }

    public String getSourceFactoryShipDate() {
        return this.sourceFactoryShipDate;
    }

    public RunwayRequestModel setSourceFactoryShipDate(final String sourceFactoryShipDate) {
        this.sourceFactoryShipDate = sourceFactoryShipDate;
        return this;
    }

    public List<ProgramOnCounterDate> getProgramOnCounterDates() {
        return this.programOnCounterDates;
    }

    public RunwayRequestModel setProgramOnCounterDates(final List<ProgramOnCounterDate> programOnCounterDates) {
        this.programOnCounterDates = programOnCounterDates;
        return this;
    }

    public List<ProductModel> getProducts() {
        return this.products;
    }

    public RunwayRequestModel setProducts(final List<ProductModel> products) {
        this.products = products;
        return this;
    }    

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RunwayRequestModel)) {
            return false;
        }
        RunwayRequestModel runwayRequestModel = (RunwayRequestModel) o;
        return Objects.equals(programId, runwayRequestModel.programId) &&
                Objects.equals(programName, runwayRequestModel.programName) &&
                Objects.equals(programBrand, runwayRequestModel.programBrand) &&
                Objects.equals(productLine, runwayRequestModel.productLine) &&
                Objects.equals(programStatus, runwayRequestModel.programStatus) &&
                Objects.equals(programStartDate, runwayRequestModel.programStartDate) &&
                Objects.equals(programEndDate, runwayRequestModel.programEndDate) &&
                Objects.equals(programType, runwayRequestModel.programType) &&
                Objects.equals(priority, runwayRequestModel.priority) &&
                Objects.equals(productRole, runwayRequestModel.productRole) &&
                Objects.equals(majorInventoryType, runwayRequestModel.majorInventoryType) &&
                Objects.equals(inventoryType, runwayRequestModel.inventoryType) &&
                Objects.equals(majorCategory, runwayRequestModel.majorCategory) &&
                Objects.equals(application, runwayRequestModel.application) &&
                Objects.equals(category, runwayRequestModel.category) &&
                Objects.equals(subCategory, runwayRequestModel.subCategory) &&
                Objects.equals(subCategoryPriority, runwayRequestModel.subCategoryPriority) &&
                Objects.equals(season, runwayRequestModel.season) &&
                Objects.equals(quarter, runwayRequestModel.quarter) &&
                Objects.equals(sourceFactoryShipDate, runwayRequestModel.sourceFactoryShipDate) &&
                Objects.equals(programOnCounterDates, runwayRequestModel.programOnCounterDates) &&
                Objects.equals(products, runwayRequestModel.products);                
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                programId, programName, programBrand, productLine, programStatus,
                programStartDate, programEndDate, programType, priority, productRole,
                majorInventoryType, inventoryType, majorCategory, application, category,
                subCategory, subCategoryPriority, season, quarter, sourceFactoryShipDate,
                programOnCounterDates, products
        );
    }

    @Override
    public String toString() {
        return "{" +
            " programId='" + getProgramId() + "'" +
            ", programName='" + getProgramName() + "'" +
            ", programBrand='" + getProgramBrand() + "'" +
            ", productLine='" + getProductLine() + "'" +
            ", programStatus='" + getProgramStatus() + "'" +
            ", programStartDate='" + getProgramStartDate() + "'" +
            ", programEndDate='" + getProgramEndDate() + "'" +
            ", programType='" + getProgramType() + "'" +
            ", priority='" + getPriority() + "'" +
            ", productRole='" + getProductRole() + "'" +
            ", majorInventoryType='" + getMajorInventoryType() + "'" +
            ", inventoryType='" + getInventoryType() + "'" +
            ", majorCategory='" + getMajorCategory() + "'" +
            ", application='" + getApplication() + "'" +
            ", category='" + getCategory() + "'" +
            ", subCategory='" + getSubCategory() + "'" +
            ", subCategoryPriority='" + getSubCategoryPriority() + "'" +
            ", season='" + getSeason() + "'" +
            ", quarter='" + getQuarter() + "'" +
            ", sourceFactoryShipDate='" + getSourceFactoryShipDate() + "'" +
            ", programOnCounterDates='" + getProgramOnCounterDates() + "'" +
            ", products='" + getProducts() + "'" +
            "}";
    }

}
