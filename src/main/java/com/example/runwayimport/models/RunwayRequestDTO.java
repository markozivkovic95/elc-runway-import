package com.example.runwayimport.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.example.runwayimport.models.constants.FieldNameConstants;

public class RunwayRequestDTO {
    
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
    private List<ProgramOnCounterDateDTO> programOnCounterDates = new ArrayList<>();

    @JsonProperty(FieldNameConstants.PRODUCTS)
    private List<ProductDTO> products = new ArrayList<>();

    public RunwayRequestDTO() {

    }

    public RunwayRequestDTO(final String programId, final String programName, final String programBrand,
            final String productLine, final String programStatus, final String programStartDate, 
            final String programEndDate, final String programType, final String priority, final String productRole,
            final String majorInventoryType, final String inventoryType, final String majorCategory,
            final String application, final String category, final String subCategory, final String subCategoryPriority,
            final String season, final String quarter, final String sourceFactoryShipDate, 
            final List<ProgramOnCounterDateDTO> programOnCounterDates, final List<ProductDTO> products) {

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

    public RunwayRequestDTO setProgramId(final String programId) {
        this.programId = programId;
        return this;
    }

    public String getProgramName() {
        return this.programName;
    }

    public RunwayRequestDTO setProgramName(final String programName) {
        this.programName = programName;
        return this;
    }

    public String getProgramBrand() {
        return this.programBrand;
    }

    public RunwayRequestDTO setProgramBrand(final String programBrand) {
        this.programBrand = programBrand;
        return this;
    }

    public String getProductLine() {
        return this.productLine;
    }

    public RunwayRequestDTO setProductLine(final String productLine) {
        this.productLine = productLine;
        return this;
    }

    public String getProgramStatus() {
        return this.programStatus;
    }

    public RunwayRequestDTO setProgramStatus(final String programStatus) {
        this.programStatus = programStatus;
        return this;
    }

    public String getProgramStartDate() {
        return this.programStartDate;
    }

    public RunwayRequestDTO setProgramStartDate(final String programStartDate) {
        this.programStartDate = programStartDate;
        return this;
    }

    public String getProgramEndDate() {
        return this.programEndDate;
    }

    public RunwayRequestDTO setProgramEndDate(final String programEndDate) {
        this.programEndDate = programEndDate;
        return this;
    }

    public String getProgramType() {
        return this.programType;
    }

    public RunwayRequestDTO setProgramType(final String programType) {
        this.programType = programType;
        return this;
    }

    public String getPriority() {
        return this.priority;
    }

    public RunwayRequestDTO setPriority(final String priority) {
        this.priority = priority;
        return this;
    }

    public String getProductRole() {
        return this.productRole;
    }

    public RunwayRequestDTO setProductRole(final String productRole) {
        this.productRole = productRole;
        return this;
    }

    public String getMajorInventoryType() {
        return this.majorInventoryType;
    }

    public RunwayRequestDTO setMajorInventoryType(final String majorInventoryType) {
        this.majorInventoryType = majorInventoryType;
        return this;
    }

    public String getInventoryType() {
        return this.inventoryType;
    }

    public RunwayRequestDTO setInventoryType(final String inventoryType) {
        this.inventoryType = inventoryType;
        return this;
    }

    public String getMajorCategory() {
        return this.majorCategory;
    }

    public RunwayRequestDTO setMajorCategory(final String majorCategory) {
        this.majorCategory = majorCategory;
        return this;
    }

    public String getApplication() {
        return this.application;
    }

    public RunwayRequestDTO setApplication(final String application) {
        this.application = application;
        return this;
    }

    public String getCategory() {
        return this.category;
    }

    public RunwayRequestDTO setCategory(final String category) {
        this.category = category;
        return this;
    }

    public String getSubCategory() {
        return this.subCategory;
    }

    public RunwayRequestDTO setSubCategory(final String subCategory) {
        this.subCategory = subCategory;
        return this;
    }

    public String getSubCategoryPriority() {
        return this.subCategoryPriority;
    }

    public RunwayRequestDTO setSubCategoryPriority(final String subCategoryPriority) {
        this.subCategoryPriority = subCategoryPriority;
        return this;
    }

    public String getSeason() {
        return this.season;
    }

    public RunwayRequestDTO setSeason(final String season) {
        this.season = season;
        return this;
    }

    public String getQuarter() {
        return this.quarter;
    }

    public RunwayRequestDTO setQuarter(final String quarter) {
        this.quarter = quarter;
        return this;
    }

    public String getSourceFactoryShipDate() {
        return this.sourceFactoryShipDate;
    }

    public RunwayRequestDTO setSourceFactoryShipDate(final String sourceFactoryShipDate) {
        this.sourceFactoryShipDate = sourceFactoryShipDate;
        return this;
    }

    public List<ProgramOnCounterDateDTO> getProgramOnCounterDates() {
        return this.programOnCounterDates;
    }

    public RunwayRequestDTO setProgramOnCounterDates(final List<ProgramOnCounterDateDTO> programOnCounterDates) {
        this.programOnCounterDates = programOnCounterDates;
        return this;
    }

    public List<ProductDTO> getProducts() {
        return this.products;
    }

    public RunwayRequestDTO setProducts(final List<ProductDTO> products) {
        this.products = products;
        return this;
    }    

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RunwayRequestDTO)) {
            return false;
        }
        RunwayRequestDTO runwayRequestDTO = (RunwayRequestDTO) o;
        return Objects.equals(programId, runwayRequestDTO.programId) &&
                Objects.equals(programName, runwayRequestDTO.programName) &&
                Objects.equals(programBrand, runwayRequestDTO.programBrand) &&
                Objects.equals(productLine, runwayRequestDTO.productLine) &&
                Objects.equals(programStatus, runwayRequestDTO.programStatus) &&
                Objects.equals(programStartDate, runwayRequestDTO.programStartDate) &&
                Objects.equals(programEndDate, runwayRequestDTO.programEndDate) &&
                Objects.equals(programType, runwayRequestDTO.programType) &&
                Objects.equals(priority, runwayRequestDTO.priority) &&
                Objects.equals(productRole, runwayRequestDTO.productRole) &&
                Objects.equals(majorInventoryType, runwayRequestDTO.majorInventoryType) &&
                Objects.equals(inventoryType, runwayRequestDTO.inventoryType) &&
                Objects.equals(majorCategory, runwayRequestDTO.majorCategory) &&
                Objects.equals(application, runwayRequestDTO.application) &&
                Objects.equals(category, runwayRequestDTO.category) &&
                Objects.equals(subCategory, runwayRequestDTO.subCategory) &&
                Objects.equals(subCategoryPriority, runwayRequestDTO.subCategoryPriority) &&
                Objects.equals(season, runwayRequestDTO.season) &&
                Objects.equals(quarter, runwayRequestDTO.quarter) &&
                Objects.equals(sourceFactoryShipDate, runwayRequestDTO.sourceFactoryShipDate) &&
                Objects.equals(programOnCounterDates, runwayRequestDTO.programOnCounterDates) &&
                Objects.equals(products, runwayRequestDTO.products);                
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
