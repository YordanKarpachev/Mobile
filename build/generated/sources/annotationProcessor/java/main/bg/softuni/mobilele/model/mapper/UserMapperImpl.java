package bg.softuni.mobilele.model.mapper;

import bg.softuni.mobilele.model.Dto.UserRegisterDTO;
import bg.softuni.mobilele.model.entiti.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-03T14:06:36+0200",
    comments = "version: 1.5.1.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity userDTOoUserEntity(UserRegisterDTO registerDTO) {
        if ( registerDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setEmail( registerDTO.getEmail() );
        userEntity.setPassword( registerDTO.getPassword() );
        userEntity.setFirstName( registerDTO.getFirstName() );
        userEntity.setLastName( registerDTO.getLastName() );

        userEntity.setActive( true );

        return userEntity;
    }
}
