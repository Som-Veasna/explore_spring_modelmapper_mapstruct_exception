package com.sna.practice.service.service.impl;

import com.sna.practice.mapper.AppUserMapper;
import com.sna.practice.model.dto.UserDTO;
import com.sna.practice.model.entity.User;
import com.sna.practice.model.request.UserResponseDTO;
import com.sna.practice.repository.UserRepository;
import com.sna.practice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AppUserMapper  appUserMapper;

    @Override
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new RuntimeException("User not found with id: " + id);
        }
        return appUserMapper.toResponseDTO(user);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return appUserMapper.toResponseDTOList(users);
    }

    @Override
    public UserResponseDTO createUser(UserDTO dto) {
        User existingUser = userRepository.findByUsername(dto.getUsername());
        if (existingUser != null) {
            throw new RuntimeException("Username already exists: " + dto.getUsername());
        }

        User user = appUserMapper.toEntity(dto);
        User saved = userRepository.insert(user);
        return appUserMapper.toResponseDTO(saved);
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserDTO dto) {
        User existing = userRepository.findById(id);
        if (existing == null) {
            throw new RuntimeException("User not found with id: " + id);
        }

        appUserMapper.updateEntityFromDTO(dto, existing);
        existing.setId(id);
        User updated = userRepository.update(existing);
        return appUserMapper.toResponseDTO(updated);
    }

    @Override
    public void deleteUser(Long id) {
        User existing = userRepository.findById(id);
        if (existing == null) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}