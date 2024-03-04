package com.softuni.mobilele.services;

import com.softuni.mobilele.domain.entities.Model;
import com.softuni.mobilele.domain.enums.Brands;
import com.softuni.mobilele.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelService {

    @Autowired
    private ModelRepository modelRepository;


    public Model findModelByBrandName(String brand) {

        Brands brandEnum = Brands.valueOf(brand);


        return this.modelRepository.findByBrand_Name(brandEnum);


    }
}
