package com.softuni.mobilele.domain.entities;

import com.softuni.mobilele.domain.enums.CarModels;
import com.softuni.mobilele.domain.enums.ModelCategory;
import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "models")
public class Model extends BaseEntity {

    @Column
    @Enumerated(EnumType.STRING)
    private CarModels name;

    @Enumerated(EnumType.STRING)
    private ModelCategory category;

    @Column
    private String imageUrl;

    @Column(nullable = false)
    private Integer startYear;

    @Column
    private Integer endYear;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column
    private LocalDateTime modified;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    public CarModels getName() {
        return name;
    }

    public Model setName(CarModels name) {
        this.name = name;
        return this;
    }

    public ModelCategory getCategory() {
        return category;
    }

    public Model setCategory(ModelCategory category) {
        this.category = category;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Model setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public Model setStartYear(Integer startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public Model setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public Model setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public Model setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    public Brand getBrand() {
        return brand;
    }

    public Model setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }
}
