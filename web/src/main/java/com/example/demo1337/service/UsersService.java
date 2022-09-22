package com.example.demo1337.service;


import com.example.demo1337.model.Users;
import com.example.demo1337.model.enumerations.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UsersService  extends UserDetailsService {

    Optional<Users> findByUsername(String user_username);
    Users findById(Integer user_id);
    List<Users> listAll();
    Users register(Integer user_id, String user_username, String user_password, String user_email, String user_name, Role role);
}
