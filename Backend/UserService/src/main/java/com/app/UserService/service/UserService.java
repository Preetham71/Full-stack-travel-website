package com.app.UserService.service;

import com.app.UserService.entity.Users;
import com.app.UserService.payload.UsersDTO;

import java.util.List;

public interface UserService {
    UsersDTO createUser(UsersDTO usersDto);
    UsersDTO getById(Long userId);
    List<UsersDTO> getAllUsers();
    UsersDTO updateUser(Long userId, UsersDTO usersDTO);
    String deleteUser(Long userId);
    UsersDTO authenticateUser(String email, String password);
    UsersDTO getUserByEmail(String email);
}


