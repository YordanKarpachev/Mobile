package com.softuni.mobilele.domain.dtoS.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

public abstract class BaseEntityDto {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private UUID id;

    public BaseEntityDto() {
    }

    public UUID getId() {
        return id;
    }

    public BaseEntityDto setId(UUID id) {
        this.id = id;
        return this;
    }

}
