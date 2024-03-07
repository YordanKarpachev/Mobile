package com.softuni.mobilele.domain.dtoS.model;

import com.softuni.mobilele.domain.enums.Brands;
import com.softuni.mobilele.domain.enums.ModelCategory;

public class BrandViewDTO {


    private Long id;
    private Brands brand;


    private String name;

    private ModelCategory category;

    private String imageUrl;

    private Integer startYear;

    private String endYear;


    public BrandViewDTO() {

    }

    public BrandViewDTO(Brands brand,  String name, ModelCategory category, String imageUrl, Integer startYear, String endYear) {
        this.brand = brand;

        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public Brands getBrand() {
        return brand;
    }

    public void setBrand(Brands brand) {
        this.brand = brand;
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

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
