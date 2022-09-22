package com.example.demo1337.service.serviceImpl;

import com.example.demo1337.model.Books;
import com.example.demo1337.model.ShoppingCart;
import com.example.demo1337.model.Users;
import com.example.demo1337.model.enumerations.ShoppingCartStatus;
import com.example.demo1337.model.exceptions.ProductAlreadyInShoppingCartException;
import com.example.demo1337.repo.ShoppingCartRepository;
import com.example.demo1337.repo.UsersRepository;
import com.example.demo1337.service.BooksService;
import com.example.demo1337.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {


    private final ShoppingCartRepository shoppingCartRepository;
    private final UsersRepository usersRepository;
    private final BooksService booksService;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, UsersRepository usersRepository, BooksService booksService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.usersRepository = usersRepository;
        this.booksService = booksService;
    }

    @Override
    public List<Books> listAllProductsInShoppingCart(Long cartId) {
        return this.shoppingCartRepository.findById(cartId).get().getBooks();
    }

    @Override
    public ShoppingCart getActiveShoppingCart(String username) {
        Users user = this.usersRepository.findByUsername(username).get();

        return this.shoppingCartRepository
                .findByUserAndStatus(user, ShoppingCartStatus.CREATED)
                .orElseGet(() -> {
                    ShoppingCart cart = new ShoppingCart(user);
                    return this.shoppingCartRepository.save(cart);
                });
    }

    @Override
    public ShoppingCart addProductToShoppingCart(String username, Integer productId) {
        ShoppingCart shoppingCart = this.getActiveShoppingCart(username);
       Books product = this.booksService.findById(productId).get();
        if(shoppingCart.getBooks()
                .stream().filter(i -> i.getBook_id().equals(productId))
                .collect(Collectors.toList()).size() > 0)
            throw new ProductAlreadyInShoppingCartException(productId, username);
        shoppingCart.getBooks().add(product);
        return this.shoppingCartRepository.save(shoppingCart);
    }
}
