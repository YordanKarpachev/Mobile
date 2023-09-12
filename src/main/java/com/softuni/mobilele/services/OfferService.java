package com.softuni.mobilele.services;

import com.softuni.mobilele.domain.dtoS.model.AllOffersDTO;
import com.softuni.mobilele.domain.entities.Offer;
import com.softuni.mobilele.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferService {

    private final OfferRepository offerRepository;

    @Autowired
    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }


    public List<AllOffersDTO> getAllOffersDTOS() {

        return this.offerRepository.findAll()
                .stream()
                .map(this::map).collect(Collectors.toList());
    }

    private AllOffersDTO map(Offer offer){

        return new AllOffersDTO(offer.getDescription(),offer.getEngine().name(),offer.getImageUrl(),offer.getMileage(),offer.getPrice(),offer.getTransmission().name());

    }
}
