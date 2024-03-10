package com.softuni.mobilele.domain.dtoS.model;



import com.softuni.mobilele.domain.entities.Brand;
import com.softuni.mobilele.domain.enums.Brands;
import com.softuni.mobilele.domain.enums.CarModels;

import java.math.BigDecimal;
import java.util.UUID;

public class AllOffersDTO {

   private Long id;
    private String description;


    private String engine;

    private String imageUrl;

    private Integer mileage;


    private BigDecimal price;


    private String transmission;

    private Integer year;

    private Brands brandName;

    private CarModels modelName;

    private String sellerEmail;

    public AllOffersDTO(String sellerEmail, Long id, String description, String engine, String imageUrl, Integer mileage, BigDecimal price, String transmission, Integer year, Brands brandName, CarModels modelName) {
      this.sellerEmail = sellerEmail;
       this.id = id;
        this.description = description;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.brandName = brandName;
        this.modelName = modelName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Brands getBrandName() {
        return brandName;
    }

    public void setBrandName(Brands brandName) {
        this.brandName = brandName;
    }

    public CarModels getModelName() {
        return modelName;
    }

    public void setModelName(CarModels modelName) {
        this.modelName = modelName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }
}