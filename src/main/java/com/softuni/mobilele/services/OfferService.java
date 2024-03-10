package com.softuni.mobilele.services;

import com.softuni.mobilele.domain.dtoS.SearchDTO;
import com.softuni.mobilele.domain.dtoS.model.AddOfferDTO;
import com.softuni.mobilele.domain.dtoS.model.AllOffersDTO;
import com.softuni.mobilele.domain.entities.Model;
import com.softuni.mobilele.domain.entities.Offer;
import com.softuni.mobilele.domain.entities.UserEntity;
import com.softuni.mobilele.domain.enums.Brands;
import com.softuni.mobilele.domain.enums.CarModels;
import com.softuni.mobilele.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OfferService {

    @Autowired
    private final OfferRepository offerRepository;


    @Autowired
    private ModelService modelService;

    @Autowired
    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }


    public Page<AllOffersDTO> getAllOffersDTOS(Pageable pageable) {

        return this.offerRepository.findAll(pageable)

                .map(this::map);
    }



    private AllOffersDTO map(Offer offer) {

        return new AllOffersDTO(offer.getSeller().getEmail(), offer.getId(), offer.getDescription(), offer.getEngine().name(), offer.getImageUrl(), offer.getMileage(), offer.getPrice(), offer.getTransmission().name(),

                offer.getYear(),
                offer.getModel().getBrand().getName(),
                offer.getModel().getName());

    }

    public void saveOffer(AddOfferDTO addOfferDTO, UserEntity user) {
        Offer offer = new Offer();
        offer.setDescription(addOfferDTO.getDescription());
        offer.setEngine(addOfferDTO.getEngine());
        offer.setImageUrl(addOfferDTO.getImageUrl());
        offer.setMileage(addOfferDTO.getMileage());
        offer.setPrice(addOfferDTO.getPrice());
        offer.setTransmission(addOfferDTO.getTransmission());
        offer.setYear(addOfferDTO.getYear());
        offer.setSeller(user);


        Model model = this.modelService.findModelByName(addOfferDTO.getCarModels());
        offer.setModel(model);
        offer.setCreated(LocalDateTime.now());
        offer.setModified(LocalDateTime.now());
        this.offerRepository.save(offer);


    }

    public Offer findById(String id) {
        return this.offerRepository.findById(id).orElseThrow(() -> new RuntimeException("offer not found"));
    }

    public void updateOffer(AddOfferDTO addOfferDTO) {
        Offer offer = this.offerRepository.findById(String.valueOf(addOfferDTO.getId()))
                .orElseThrow(() -> new RuntimeException("offer not found"));

        offer.setPrice(addOfferDTO.getPrice());
        offer.setEngine(addOfferDTO.getEngine());
        offer.setTransmission(addOfferDTO.getTransmission());
        offer.setYear(addOfferDTO.getYear());
        offer.setMileage(addOfferDTO.getMileage());
        offer.setModified(LocalDateTime.now());

        Model model = this.modelService.findModelByName(addOfferDTO.getCarModels());
        offer.setModel(model);

        this.offerRepository.save(offer);


    }

    public void deleteOffer(String id) {
        Offer offer = this.offerRepository.findById(id).orElseThrow(() -> new RuntimeException("offer don´t exist"));
        this.offerRepository.delete(offer);
    }

    public long findCountOffersByBrand(Brands brand) {
        return this.offerRepository.countAllByBrand(brand);

    }

    public long findCountOffersByModelAndBrand(Brands brand, CarModels model) {
        return this.offerRepository.countAllByBrandAndModel(brand, model);

    }

    public long findOffersByModelAndBrandAndYear(Brands brand, CarModels model, Integer year) {
        return this.offerRepository.countAllByBrandAndModelAndYear(brand, model, year);
    }

    public Page<AllOffersDTO> getAllOffersByBrand(Pageable pageable, Brands brands) {
        return offerRepository.findAllByBrandName(brands, pageable).map(this::map);

    }

    public Page<AllOffersDTO> getAllOffersByModel(Pageable pageable, CarModels model) {
        return offerRepository.findAllByModelName(model, pageable).map(this::map);

    }


    public Page<AllOffersDTO> getAllOffersByModelAndYear(Pageable pageable, CarModels model, Integer year) {
        return offerRepository.findAllByModelNameAndYearGreaterThanOrEqual(model, year, pageable).map(this::map);

    }

    public Page<AllOffersDTO> getOffers(Pageable pageable, SearchDTO searchDTO) {

        if (searchDTO.getName() != null && searchDTO.getModel() != null && searchDTO.getYear() == null) {
            return this.getAllOffersByModel(pageable, searchDTO.getModel());


        } else if (searchDTO.getName() != null && searchDTO.getModel() != null && searchDTO.getYear() != null) {

            return this.getAllOffersByModelAndYear(pageable, searchDTO.getModel(), searchDTO.getYear());

        }

        return this.getAllOffersByBrand(pageable, searchDTO.getName());
    }

    public long calculateTotalOffers(Brands brand, CarModels model, Integer year) {
        if (brand != null && model == null && year == null) {
            return this.findCountOffersByBrand(brand);
        } else if (brand != null && model != null && year == null) {
            return this.findCountOffersByModelAndBrand(brand, model);
        } else if (brand != null && model != null) {
            return this.findOffersByModelAndBrandAndYear(brand, model, year);
        } else {

            return 0;
        }

    }

    public Page<AllOffersDTO> findAllBySeller(Pageable pageable, String email) {
      return   this.offerRepository.findAllBySellerEmail(  email, pageable).map(this::map);
    }
}
