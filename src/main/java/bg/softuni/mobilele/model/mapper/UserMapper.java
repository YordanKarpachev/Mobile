package bg.softuni.mobilele.model.mapper;

import bg.softuni.mobilele.model.Dto.UserRegisterDTO;
import bg.softuni.mobilele.model.entiti.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")

public interface UserMapper {

    @Mapping(target = "active", constant = "true")
    UserEntity userDTOoUserEntity(UserRegisterDTO registerDTO);
}
