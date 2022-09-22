package com.example.demo1337.web.controller;

import com.example.demo1337.model.ShoppingCart;
import com.example.demo1337.model.Users;
import com.example.demo1337.service.ShoppingCartService;
import com.example.demo1337.service.UsersService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;
    private final UsersService usersService;

    public ShoppingCartController(ShoppingCartService shoppingCartService, UsersService usersService) {
        this.shoppingCartService = shoppingCartService;
        this.usersService = usersService;
    }

    @GetMapping
    public String getShoppingCartPage(@RequestParam(required = false) String error,
                                      HttpServletRequest req,
                                      Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        String username = req.getRemoteUser();
        ShoppingCart shoppingCart = this.shoppingCartService.getActiveShoppingCart(username);
        model.addAttribute("products", this.shoppingCartService.listAllProductsInShoppingCart(shoppingCart.getId()));
        model.addAttribute("bodyContent", "shopping-cart");
        return "master-template";
    }

    @PostMapping("/add-product/{id}")
    public String addProductToShoppingCart(@PathVariable Integer id, HttpServletRequest req, Authentication authentication) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Users user = this.usersService.findByUsername(auth.getName()).get();
            this.shoppingCartService.addProductToShoppingCart(user.getUser_username(), id);
            return "redirect:/shopping-cart";
        } catch (RuntimeException exception) {
            return "redirect:/shopping-cart?error=" + exception.getMessage();
        }
    }
}

