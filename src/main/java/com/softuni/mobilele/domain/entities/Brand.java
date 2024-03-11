package com.softuni.mobilele.domain.entities;

import com.softuni.mobilele.domain.enums.Brands;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private Brands name;
// test

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    Set<Model> models;


    public Brand() {
    }

    public Set<Model> getModels() {
        return models;
    }

    public void setModels(Set<Model> models) {
        this.models = models;
    }

    public Brands getName() {
        return name;
    }

    public Brand setName(Brands name) {
        this.name = name;
        return this;
    }
}