package com.softuni.mobilele.domain.dtoS.model;

import com.softuni.mobilele.domain.entities.Brand;
import com.softuni.mobilele.domain.enums.Engine;
import com.softuni.mobilele.domain.enums.Transmission;

import java.math.BigDecimal;
import java.util.Date;

public class OfferDetailsDTO {

    private String id;
    private String brandName;

    private String model;
    private Engine engine;

    private BigDecimal price;

    private Transmission transmission;

    private Date created;

    private Date modified;

    private String seller;

    public OfferDetailsDTO( ) {

    }

    public OfferDetailsDTO(String brandName,String model, Engine engine, BigDecimal price, Transmission transmission, Date created, Date modified, String seller) {
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }



    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
