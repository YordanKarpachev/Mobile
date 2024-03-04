package com.softuni.mobilele.repositories;

import com.softuni.mobilele.domain.entities.Model;
import com.softuni.mobilele.domain.enums.Brands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, String> {
    Model findByBrand_Name(Brands brandName);


}
