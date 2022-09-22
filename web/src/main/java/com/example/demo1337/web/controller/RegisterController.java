package com.example.demo1337.web.controller;


import com.example.demo1337.model.enumerations.Role;
import com.example.demo1337.repo.UsersRepository;
import com.example.demo1337.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UsersService usersService;
    private final UsersRepository usersRepository;

    public RegisterController(UsersService usersService, UsersRepository usersRepository) {
        this.usersService = usersService;
        this.usersRepository = usersRepository;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("bodyContent", "register");
        return "master-template";
    }


    @PostMapping
    public String register(@RequestParam Integer user_id,
                           @RequestParam String user_username,
                           @RequestParam String user_password,
                           @RequestParam String user_email,
                           @RequestParam String user_name,
                            @RequestParam Role user_role)
                           {

            this.usersService.register( user_id, user_username, user_password
                   , user_name,  user_email,user_role);
            return "redirect:/login";
    }
}
