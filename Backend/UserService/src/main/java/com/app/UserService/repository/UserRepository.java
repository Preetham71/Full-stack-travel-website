package com.app.UserService.repository;
import com.app.UserService.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByUserEmail(String email);
}
