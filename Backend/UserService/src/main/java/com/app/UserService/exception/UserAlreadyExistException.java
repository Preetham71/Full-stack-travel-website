package com.app.UserService.exception;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(){
        super("User Already Exits...");
    }
}
