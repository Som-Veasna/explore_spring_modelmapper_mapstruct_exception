package com.sna.practice.mapper;

import com.sna.practice.model.dto.UserDTO;
import com.sna.practice.model.entity.Address;
import com.sna.practice.model.entity.User;
import com.sna.practice.model.response.UserResponse;
import com.sna.practice.repository.AddressRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public abstract class UserMapper {

    @Autowired
    private AddressRepository addressRepository;

    @Mapping(target = "id",      ignore = true)
    @Mapping(target = "address", source = "addressId", qualifiedByName = "idToAddress")
    public abstract User toEntity(UserDTO dto);

    public abstract UserResponse toResponse(User user);

    public abstract List<UserResponse> toResponseList(List<User> users);

    @Mapping(target = "id",      ignore = true)
    @Mapping(target = "address", source = "addressId", qualifiedByName = "idToAddress")
    public abstract void updateEntityFromDTO(UserDTO dto, @MappingTarget User user);

    @Named("idToAddress")
    public Address idToAddress(Integer addressId) {
        if (addressId == null) return null;
        return addressRepository.findById(Long.valueOf(addressId));
    }
}