package com.softuni.mobilele.domain.dtoS.model;

import com.softuni.mobilele.domain.enums.Brands;
import com.softuni.mobilele.domain.enums.CarModels;
import com.softuni.mobilele.domain.enums.Engine;
import com.softuni.mobilele.domain.enums.Transmission;
import jakarta.transaction.Transaction;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class AddOfferDTO {

    @NotNull
    private Brands brand;

    @NotNull
    private CarModels carModels;

    private Long id;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Engine engine;

    @NotNull
    private Integer mileage;

    @NotNull
    private Transmission transmission;

    @NotNull
    private Integer year;

    @NotNull
    private String description;

    @NotNull
    private String imageUrl;


    public AddOfferDTO() {
    }

    public Brands getBrand() {
        return brand;
    }

    public void setBrand(Brands brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarModels getCarModels() {
        return carModels;
    }

    public void setCarModels(CarModels carModels) {
        this.carModels = carModels;
    }
}
