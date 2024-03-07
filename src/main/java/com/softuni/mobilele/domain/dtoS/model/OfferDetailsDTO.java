package com.softuni.mobilele.domain.dtoS.model;

import com.softuni.mobilele.domain.entities.Brand;
import com.softuni.mobilele.domain.enums.Brands;
import com.softuni.mobilele.domain.enums.CarModels;
import com.softuni.mobilele.domain.enums.Engine;
import com.softuni.mobilele.domain.enums.Transmission;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class OfferDetailsDTO {

    private Long id;
    private Brands brandName;

    private CarModels model;
    private Engine engine;

    private BigDecimal price;

    private Transmission transmission;

    private LocalDateTime created;

    private LocalDateTime modified;

    private String seller;


    private String imageUrl;
    public OfferDetailsDTO( ) {

    }

    public OfferDetailsDTO(Long id,String imageUrl, Brands brandName,CarModels model, Engine engine, BigDecimal price, Transmission transmission, LocalDateTime created, LocalDateTime modified, String seller) {
       this.id = id;
        this.imageUrl = imageUrl;
        this.model = model;
        this.brandName = brandName;
        this.engine = engine;
        this.price = price;
        this.transmission = transmission;
        this.created = created;
        this.modified = modified;
        this.seller = seller;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }



    public CarModels getModel() {
        return model;
    }

    public void setModel(CarModels model) {
        this.model = model;
    }

    public Brands getBrandName() {
        return brandName;
    }

    public void setBrandName(Brands brandName) {
        this.brandName = brandName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
