package com.example.demo1337.repo;

import com.example.demo1337.model.ShoppingCart;
import com.example.demo1337.model.Users;
import com.example.demo1337.model.enumerations.ShoppingCartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    Optional<ShoppingCart> findByUserAndStatus(Users user, ShoppingCartStatus status);
}