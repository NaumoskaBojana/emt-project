package com.example.demo1337.service;

import com.example.demo1337.model.Books;
import com.example.demo1337.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    List<Books> listAllProductsInShoppingCart(Long cartId);

    ShoppingCart getActiveShoppingCart(String username);

    public ShoppingCart addProductToShoppingCart(String username, Integer productId);


}
