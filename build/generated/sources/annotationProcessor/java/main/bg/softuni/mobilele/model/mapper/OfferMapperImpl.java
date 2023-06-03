package bg.softuni.mobilele.model.mapper;

import bg.softuni.mobilele.model.Dto.AddOfferDTO;
import bg.softuni.mobilele.model.entiti.OfferEntity;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-03T14:06:36+0200",
    comments = "version: 1.5.1.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class OfferMapperImpl implements OfferMapper {

    @Override
    public OfferEntity addOfferDtoToOfferEntity(AddOfferDTO addOfferDTO) {
        if ( addOfferDTO == null ) {
            return null;
        }

        OfferEntity offerEntity = new OfferEntity();

        offerEntity.setEngine( addOfferDTO.getEngine() );
        offerEntity.setImageUrl( addOfferDTO.getImageUrl() );
        if ( addOfferDTO.getMileage() != null ) {
            offerEntity.setMileage( addOfferDTO.getMileage() );
        }
        if ( addOfferDTO.getPrice() != null ) {
            offerEntity.setPrice( BigDecimal.valueOf( addOfferDTO.getPrice() ) );
        }
        offerEntity.setTransmission( addOfferDTO.getTransmission() );
        if ( addOfferDTO.getYear() != null ) {
            offerEntity.setYear( addOfferDTO.getYear() );
        }
        offerEntity.setDescription( addOfferDTO.getDescription() );

        return offerEntity;
    }
}
