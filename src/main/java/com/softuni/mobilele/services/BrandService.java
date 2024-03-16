package com.softuni.mobilele.services;

import com.softuni.mobilele.domain.entities.Brand;
import com.softuni.mobilele.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {


    @Autowired
    private BrandRepository brandRepository;


    public List<Brand> getAllBrands() {
        return this.brandRepository.findAll();
    }
}
