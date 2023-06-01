package bg.softuni.mobilele.service;


import bg.softuni.mobilele.model.Dto.AddOfferDTO;
import bg.softuni.mobilele.model.entiti.ModelEntity;
import bg.softuni.mobilele.model.entiti.OfferEntity;
import bg.softuni.mobilele.model.entiti.UserEntity;
import bg.softuni.mobilele.model.mapper.OfferMapper;
import bg.softuni.mobilele.repository.ModelRepository;
import bg.softuni.mobilele.repository.OfferRepository;
import bg.softuni.mobilele.repository.UserRepository;

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
