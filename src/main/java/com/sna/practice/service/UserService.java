package com.sna.practice.service;

import com.sna.practice.model.dto.UserDTO;
import com.sna.practice.model.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse getUserById(Long id);
    List<UserResponse>   getAllUsers();
    UserResponse createUser(UserDTO dto);
    UserResponse updateUser(Long id, UserDTO dto);
    void deleteUser(Long id);
}