package com.softuni.mobilele.domain.dtoS.model;

import com.softuni.mobilele.domain.enums.Brands;
import com.softuni.mobilele.domain.enums.CarModels;
import com.softuni.mobilele.domain.enums.ModelCategory;
import com.softuni.mobilele.domain.enums.Transmission;

public class BrandViewDTO {


    private Long id;
    private Brands brandName;


    private CarModels modelName;

    private ModelCategory category;

    private String imageUrl;

    private Integer startYear;

    private String endYear;




    public BrandViewDTO() {

    }

    public BrandViewDTO( Brands brand, CarModels modelName, ModelCategory category, String imageUrl, Integer startYear, String endYear) {
        this.brandName = brand;


        this.modelName = modelName;
        this.category = category;
        this.imageUrl = imageUrl;
        this.startYear = startYear;
        this.endYear = endYear;
    }





    public CarModels getModelName() {
        return modelName;
    }

    public void setModelName(CarModels modelName) {
        this.modelName = modelName;
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

    public Brands getBrandName() {
        return brandName;
    }

    public void setBrandName(Brands brandName) {
        this.brandName = brandName;
    }


}
