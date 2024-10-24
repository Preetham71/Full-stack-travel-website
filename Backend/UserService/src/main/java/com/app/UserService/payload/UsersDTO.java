package com.app.UserService.payload;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersDTO {
    private Long userId;
    @NotEmpty(message = "User Name must not be Empty")
    private String userName;
    @Email(message = "Enter a valid Email")
    private String userEmail;
    @NotEmpty(message = "Phone number must not be Empty")
    @Size(min = 10,max = 10, message = "Phone number must be of 10 digits")
    private String userPhone;
    @NotEmpty(message = "Password must not be Empty")
    @Size(min = 6,max = 12,message = "Password length must be between 6 and 12")
    private String userPassword;
    @NotEmpty(message = "Address must not be Empty")
    private String userAddress;
    private UserRole userRole;

}
