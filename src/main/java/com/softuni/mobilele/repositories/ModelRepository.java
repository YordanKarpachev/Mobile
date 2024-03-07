package com.softuni.mobilele.repositories;

import com.softuni.mobilele.domain.entities.Brand;
import com.softuni.mobilele.domain.entities.Model;
import com.softuni.mobilele.domain.enums.Brands;
import com.softuni.mobilele.domain.enums.CarModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, String> {
    Model findByBrand_Name(Brands brandName);



    List<Model> findAllByBrandName(Brands brandEnum);

    Model findByName(CarModels carModels);
}
