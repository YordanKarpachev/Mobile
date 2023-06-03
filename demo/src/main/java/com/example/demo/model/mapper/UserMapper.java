package com.example.demo.model.mapper;


import com.example.demo.model.Dto.UserRegisterDTO;
import com.example.demo.model.entiti.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")

public interface UserMapper {

    @Mapping(target = "active", constant = "true")
    UserEntity userDTOoUserEntity(UserRegisterDTO registerDTO);
}
