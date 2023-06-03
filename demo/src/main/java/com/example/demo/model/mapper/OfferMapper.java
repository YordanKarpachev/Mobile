package com.example.demo.model.mapper;

import com.example.demo.model.Dto.AddOfferDTO;
import com.example.demo.model.entiti.OfferEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    OfferEntity addOfferDtoToOfferEntity(AddOfferDTO addOfferDTO);
}
