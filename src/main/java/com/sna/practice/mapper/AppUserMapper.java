package com.sna.practice.mapper;

import com.sna.practice.model.dto.UserDTO;
import com.sna.practice.model.entity.User;
import com.sna.practice.model.request.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AppUserMapper {

    private final ModelMapper modelMapper;

    public User toEntity(UserDTO dto) {
        return modelMapper.map(dto, User.class);
    }

    public UserResponseDTO toResponseDTO(User user) {
        return modelMapper.map(user, UserResponseDTO.class);
    }
    public List<UserResponseDTO> toResponseDTOList(List<User> users) {
        return users.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public void updateEntityFromDTO(UserDTO dto, User user) {
        modelMapper.map(dto, user);
    }
}