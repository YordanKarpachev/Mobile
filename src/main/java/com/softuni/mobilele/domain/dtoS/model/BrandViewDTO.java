package com.softuni.mobilele.domain.dtoS.model;

import com.softuni.mobilele.domain.enums.ModelCategory;

public class BrandViewDTO {


    private Long id;
    private String brand;

    private String modelName;
    private String name;

    private ModelCategory category;

    private String imageUrl;

    private Integer startYear;

    private Integer endYear;


    public BrandViewDTO() {

    }

    public BrandViewDTO(String brand, String modelName, String name, ModelCategory category, String imageUrl, Integer startYear, Integer endYear) {
        this.brand = brand;
        this.modelName = modelName;
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ModelCategory getCategory() {
        return category;
    }

    public void setCategory(ModelCategory category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
