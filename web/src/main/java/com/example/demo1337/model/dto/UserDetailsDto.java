package com.example.demo1337.model.dto;

import com.example.demo1337.model.Users;
import com.example.demo1337.model.enumerations.Role;
import lombok.Data;

@Data
public class UserDetailsDto {
    private String username;
    private Role role;

    public static UserDetailsDto of(Users user) {
        UserDetailsDto details = new UserDetailsDto();
        details.username = user.getUser_username();
        details.role = user.getRole();
        return details;
    }
}
