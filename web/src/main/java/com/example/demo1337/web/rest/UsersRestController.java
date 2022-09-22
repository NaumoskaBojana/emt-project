package com.example.demo1337.web.rest;

import com.example.demo1337.model.Books;
import com.example.demo1337.model.Users;
import com.example.demo1337.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/users")
public class UsersRestController {

    private final UsersService usersService;

    public UsersRestController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    private List<Users> findAll() {
        return this.usersService.listAll();
    }


}