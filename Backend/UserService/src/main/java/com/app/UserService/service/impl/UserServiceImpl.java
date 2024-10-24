package com.app.UserService.service.impl;
import com.app.UserService.entity.Users;
import com.app.UserService.exception.ResourceNotFoundException;
import com.app.UserService.exception.UserAlreadyExistException;
import com.app.UserService.payload.ErrorResponseDto;
import com.app.UserService.payload.UsersDTO;
import com.app.UserService.repository.UserRepository;
import com.app.UserService.service.UserService;
import com.app.UserService.util.MapperLibrary;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final MapperLibrary mapperLibrary;

    @Override
    public UsersDTO createUser(UsersDTO usersDto) {
        System.out.println(usersDto);
        try {
            Users users = userRepository.save(mapperLibrary.mapToUsers(usersDto));
            return mapperLibrary.mapToUsersDto(users);
        }
        catch (Exception e){
            throw new UserAlreadyExistException();
        }

    }

    @Override
    public UsersDTO getById(Long userId) {
        Users users = userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("Users","id",userId.toString())
        );
        return mapperLibrary.mapToUsersDto(users);
    }
    @Override
    public List<UsersDTO> getAllUsers() {
        List<Users> usersList = userRepository.findAll();
        return usersList.stream().map(user -> mapperLibrary.mapToUsersDto(user)).toList();
    }
    @Override
    public UsersDTO updateUser(Long userId, UsersDTO usersDTO) {
        UsersDTO usersDTO1 = getById(userId);
        usersDTO1.setUserAddress(usersDTO.getUserAddress());
        usersDTO1.setUserEmail(usersDTO.getUserEmail());
        usersDTO1.setUserName(usersDTO.getUserName());
        usersDTO1.setUserPassword(usersDTO.getUserPassword());
        usersDTO1.setUserPhone(usersDTO.getUserPhone());
        return mapperLibrary.mapToUsersDto(
                userRepository.save(mapperLibrary.mapToUsers(usersDTO1))
        );
    }
    @Override
    public String deleteUser(Long userId) {
        getById(userId);
        userRepository.deleteById(userId);
        return "User deleted successfully";
    }
    @Override
    public UsersDTO getUserByEmail(String email){
        Users users  = userRepository.findByUserEmail(email);
        return mapperLibrary.mapToUsersDto(users);
    }

    @Override
    public UsersDTO authenticateUser(String email, String password) {
        System.out.println(email+" " + password);
        Users users= userRepository.findByUserEmail(email);
        if (users!=null&& users.getUserPassword().equals(password))
            return mapperLibrary.mapToUsersDto(users);
        throw new ResourceNotFoundException("User","email",email);
    }
}


