package com.softuni.mobilele.domain.entities;


import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class UserActivationLinkEntity extends BaseEntity {

    @OneToOne
    private  UserEntity user;

    private String code;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
