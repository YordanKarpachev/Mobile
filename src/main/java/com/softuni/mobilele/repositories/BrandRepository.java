package com.softuni.mobilele.repositories;

import com.softuni.mobilele.domain.entities.Brand;
import com.softuni.mobilele.domain.enums.Brands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, String> {
    Optional<Brand> findByName(Brands name);
}


