package com.app.UserService.util;


import com.app.UserService.UserServiceApplication;
import com.app.UserService.entity.Users;
import com.app.UserService.payload.UsersDTO;
import org.springframework.stereotype.Component;

@Component
public class MapperLibrary {
    public Users mapToUsers(UsersDTO usersDto) {
        return UserServiceApplication.modelMapper().map(usersDto, Users.class);
    }

    public UsersDTO mapToUsersDto(Users users) {
        return UserServiceApplication.modelMapper().map(users, UsersDTO.class);
    }
}


