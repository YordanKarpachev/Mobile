package com.softuni.mobilele.services;

import com.softuni.mobilele.domain.dtoS.model.AddOfferDTO;
import com.softuni.mobilele.domain.dtoS.model.AllOffersDTO;
import com.softuni.mobilele.domain.entities.Offer;
import com.softuni.mobilele.domain.entities.UserEntity;
import com.softuni.mobilele.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class OfferService {

    @Autowired
    private final OfferRepository offerRepository;

    @Autowired
    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }


    public Page<AllOffersDTO> getAllOffersDTOS(Pageable pageable) {

        return this.offerRepository.findAll(pageable)

                .map(this::map);
    }

    public boolean hasOffers(){
      return  this.offerRepository.count() == 0;
    }

    private AllOffersDTO map(Offer offer) {

        return new AllOffersDTO(offer.getId(), offer.getDescription(), offer.getEngine().name(), offer.getImageUrl(), offer.getMileage(), offer.getPrice(), offer.getTransmission().name(),
                offer.getYear());
                // offer.getModel().getBrand().getName());
              //  offer.getModel().getName());

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
     //TODO  offer.setModel(addOfferDTO.getBrand());


        this.offerRepository.save(offer);


    }

    public Offer findById(String id) {
        return this.offerRepository.findById(id).orElseThrow(() -> new RuntimeException("offer not found"));
    }
}
