package com.app.UserService.controller;

import com.app.UserService.payload.LoginDTO;
import com.app.UserService.payload.UsersDTO;
import com.app.UserService.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("users")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {

    private UserServiceImpl userService;
    @PostMapping("/register")
    public ResponseEntity<UsersDTO> addUser(@Valid @RequestBody UsersDTO usersDto) {
        UsersDTO newUser = userService.createUser(usersDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping("/{userId}")
    public UsersDTO getUsersById(@PathVariable Long userId) {
        return userService.getById(userId);
    }

    @GetMapping("/all")
    public List<UsersDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{userId}")
    public UsersDTO updateUser(@PathVariable Long userId, @RequestBody UsersDTO usersDTO) {
        return userService.updateUser(userId, usersDTO);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        String message = userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
    @GetMapping("/email/{email}")
    public UsersDTO getUserByUserEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public UsersDTO loginUser(@RequestBody LoginDTO loginDTO){

        UsersDTO usersDTO = userService.authenticateUser(loginDTO.getEmail(), loginDTO.getPassword());
        return usersDTO;
    }



}

