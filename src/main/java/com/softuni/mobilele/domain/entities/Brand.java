package com.softuni.mobilele.domain.entities;

import com.softuni.mobilele.domain.enums.Brands;
import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private Brands name;

    public Brands getName() {
        return name;
    }

    public Brand setName(Brands name) {
        this.name = name;
        return this;
    }
}