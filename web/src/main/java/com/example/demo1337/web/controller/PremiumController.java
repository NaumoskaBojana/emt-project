package com.example.demo1337.web.controller;


import com.example.demo1337.model.Users;
import com.example.demo1337.model.enumerations.Role;
import com.example.demo1337.repo.UsersRepository;
import com.example.demo1337.service.UsersService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/become-premium")
public class PremiumController {

    private final UsersService usersService;
    private final UsersRepository usersRepository;

    public PremiumController(UsersService usersService, UsersRepository usersRepository) {
        this.usersService = usersService;
        this.usersRepository = usersRepository;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("bodyContent", "premium");
        return "master-template";
    }

    @PostMapping
    public String register()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = this.usersService.findByUsername(auth.getName()).get();
        user.setUser_role(Role.valueOf("ROLE_PREMIUM"));
        this.usersRepository.delete(user);
        this.usersRepository.save(user);
        return "redirect:/home";
    }
}
