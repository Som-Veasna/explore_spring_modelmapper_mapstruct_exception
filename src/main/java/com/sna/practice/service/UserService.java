package com.sna.practice.service;

import com.sna.practice.model.dto.UserDTO;
import com.sna.practice.model.request.UserResponseDTO;

import java.util.List;

public interface UserService {

    UserResponseDTO getUserById(Long id);
    List<UserResponseDTO>   getAllUsers();
    UserResponseDTO         createUser(UserDTO dto);
    UserResponseDTO         updateUser(Long id, UserDTO dto);
    void                    deleteUser(Long id);
}