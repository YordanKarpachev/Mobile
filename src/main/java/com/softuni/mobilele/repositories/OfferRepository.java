package com.softuni.mobilele.repositories;

import com.softuni.mobilele.domain.entities.Offer;
import com.softuni.mobilele.domain.enums.Brands;
import com.softuni.mobilele.domain.enums.CarModels;
import com.softuni.mobilele.services.OfferService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, String> {



    @Query("SELECT COUNT(o) FROM Offer o WHERE o.model.brand.name = :brand")
    long countAllByBrand(Brands brand);

    @Query("SELECT COUNT(o) FROM Offer o WHERE o.model.brand.name = :brand AND o.model.name = :model")
    long countAllByBrandAndModel(@Param("brand") Brands brand, @Param("model") CarModels model);


    @Query("SELECT COUNT(o) FROM Offer o WHERE o.model.brand.name = :brand AND o.model.name = :model AND o.year >= :year")
    long countAllByBrandAndModelAndYear(@Param("brand") Brands brand, @Param("model") CarModels model, @Param("year") Integer year);

    @Query("SELECT o FROM Offer o WHERE o.model.brand.name = :brandName")
    Page<Offer> findAllByBrandName(@Param("brandName") Brands brandName, Pageable pageable);

    @Query("SELECT o FROM Offer o WHERE o.model.name = :modelName")
    Page<Offer> findAllByModelName(@Param("modelName") CarModels modelName, Pageable pageable);

    @Query("SELECT o FROM Offer o WHERE o.model.name = :modelName AND o.year >= :year")
    Page<Offer> findAllByModelNameAndYearGreaterThanOrEqual(
            @Param("modelName") CarModels modelName,
            @Param("year") Integer year,
            Pageable pageable);

    Page<Offer>  findAllBySellerEmail(String email, Pageable pageable);

    @Query("SELECT o FROM Offer o ORDER BY CASE WHEN o.seller.email = :email THEN 0 ELSE 1 END, o.id")
    Page<Offer> findAllSortedBySellerEmail(@Param("email") String email, Pageable pageable);


}
