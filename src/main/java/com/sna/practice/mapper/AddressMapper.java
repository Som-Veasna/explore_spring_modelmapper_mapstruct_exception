package com.sna.practice.mapper;


import com.sna.practice.model.dto.AddressDTO;
import com.sna.practice.model.entity.Address;
import com.sna.practice.model.response.AddressResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(target = "id", ignore = true)
    Address toEntity(AddressDTO dto);

    AddressResponse toResponse(Address address);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(AddressDTO dto, @MappingTarget Address address);
}