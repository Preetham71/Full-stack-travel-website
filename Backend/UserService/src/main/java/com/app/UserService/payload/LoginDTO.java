package com.app.UserService.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LoginDTO {
    @Email(message = "Enter a valid Email")
    private String email;
    @NotEmpty(message = "Password must not be Empty")
    @Size(min = 6,max = 12,message = "Password length must be between 6 and 12")
    private String password;
}