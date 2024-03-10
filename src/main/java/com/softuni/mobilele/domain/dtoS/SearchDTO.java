package com.softuni.mobilele.domain.dtoS;

import com.softuni.mobilele.domain.enums.Brands;
import com.softuni.mobilele.domain.enums.CarModels;

import java.math.BigDecimal;

public class SearchDTO {

    private Brands name;

    private CarModels model;

    private Integer year;

    private Integer mileage;

    private Integer price;

    public SearchDTO() {
    }

    public Brands getName() {
        return name;
    }

    public void setName(Brands name) {
        this.name = name;
    }

    public CarModels getModel() {
        return model;
    }

    public void setModel(CarModels model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
