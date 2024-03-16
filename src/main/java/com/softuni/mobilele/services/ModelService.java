package com.softuni.mobilele.services;

import com.softuni.mobilele.domain.entities.Brand;
import com.softuni.mobilele.domain.entities.Model;
import com.softuni.mobilele.domain.enums.Brands;
import com.softuni.mobilele.domain.enums.CarModels;
import com.softuni.mobilele.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {

    @Autowired
    private ModelRepository modelRepository;


    public List<CarModels> findModelsByBrandName(String brand) {

        Brands brandEnum = Brands.valueOf(brand);
   List<Model> models =  this.modelRepository.findAllByBrandName(brandEnum);

   return models.stream().map(Model::getName).toList();

    }
    public Model findModelByName(CarModels carModels) {
    return  this.modelRepository.findByName(carModels);
    }
}
