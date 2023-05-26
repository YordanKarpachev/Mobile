package bg.softuni.mobilele.model.mapper;

import bg.softuni.mobilele.model.Dto.AddOfferDTO;
import bg.softuni.mobilele.model.entiti.OfferEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    OfferEntity addOfferDtoToOfferEntity(AddOfferDTO addOfferDTO);
}
