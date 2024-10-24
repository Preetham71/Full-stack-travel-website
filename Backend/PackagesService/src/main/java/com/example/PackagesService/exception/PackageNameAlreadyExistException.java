package com.example.PackagesService.exception;

public class PackageNameAlreadyExistException extends RuntimeException{
    public PackageNameAlreadyExistException(){
        super("Package Name Already Exist.");
    }
}
