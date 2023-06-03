package com.example.demo.service;


import com.example.demo.model.Dto.AddOfferDTO;
import com.example.demo.model.entiti.ModelEntity;
import com.example.demo.model.entiti.OfferEntity;
import com.example.demo.model.entiti.UserEntity;
import com.example.demo.model.mapper.OfferMapper;
import com.example.demo.repository.ModelRepository;
import com.example.demo.repository.OfferRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class OfferService {


    private final OfferMapper offerMapper;
    private final OfferRepository offerRepository;

    private UserRepository userRepository;


    private final ModelRepository modelRepository;

    public OfferService(OfferMapper offerMapper, OfferRepository offerRepository, UserRepository userRepository,  ModelRepository modelRepository) {
        this.offerMapper = offerMapper;
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;

        this.modelRepository = modelRepository;
    }


    public void addOffer(AddOfferDTO addOfferDTO, UserDetails userDetails){

        OfferEntity newOffer = offerMapper
                .addOfferDtoToOfferEntity(addOfferDTO);

        UserEntity seller = userRepository.findByEmail(userDetails.getUsername()).orElseThrow();

        ModelEntity model = modelRepository.findById(addOfferDTO.getModelId()).orElseThrow();
        newOffer.setModel(model);
        newOffer.setSeller(seller);

        this.offerRepository.save(newOffer);
    }


}
