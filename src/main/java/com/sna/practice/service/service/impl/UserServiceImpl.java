package com.sna.practice.service.service.impl;

import com.sna.practice.exception.AlreadyExistsException;
import com.sna.practice.exception.NotFoundException;
import com.sna.practice.mapper.UserMapper;
import com.sna.practice.model.dto.UserDTO;
import com.sna.practice.model.entity.User;
import com.sna.practice.model.response.UserResponse;
import com.sna.practice.repository.UserRepository;
import com.sna.practice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper     userMapper;

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new NotFoundException("User not found with id: " + id);
        }
        return userMapper.toResponse(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userMapper.toResponseList(userRepository.findAll());
    }

    @Override
    public UserResponse createUser(UserDTO dto) {
        User existingUser = userRepository.findByUsername(dto.getUsername());
        if (existingUser != null) {
            throw new AlreadyExistsException("Username already exists: " + dto.getUsername());  // ✅
        }
        User user  = userMapper.toEntity(dto);
        User saved = userRepository.insert(user);
        return userMapper.toResponse(saved);
    }

    @Override
    public UserResponse updateUser(Long id, UserDTO dto) {
        User existing = userRepository.findById(id);
        if (existing == null) {
            throw new NotFoundException("User not found with id: " + id);
        }
        userMapper.updateEntityFromDTO(dto, existing);
        existing.setId(id);
        User updated = userRepository.update(existing);
        return userMapper.toResponse(updated);
    }

    @Override
    public void deleteUser(Long id) {
        User existing = userRepository.findById(id);
        if (existing == null) {
            throw new NotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}