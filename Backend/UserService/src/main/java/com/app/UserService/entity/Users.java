package com.app.UserService.entity;
import com.app.UserService.payload.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class Users {
    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name="userName",unique = true)
    private String userName;

    @Column(name="userEmail",unique = true)
    private String userEmail;

    @Column(name="userPhone",unique = true)
    private String userPhone;

    @Column(name="userPassword")
    private  String userPassword;

    @Column(name = "userAddress")
    private String userAddress;

    @Enumerated(EnumType.STRING)
    @Column(name="userRole")
    private UserRole userRole;

}