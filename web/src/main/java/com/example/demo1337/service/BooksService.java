package com.example.demo1337.service;

import com.example.demo1337.model.Books;
import com.example.demo1337.model.dto.BooksDto;

import java.util.List;
import java.util.Optional;

public interface BooksService {


    List<Books> findAll();

    Optional<Books> findById(Integer id);

    Optional<Books> findByName(String name);

    public Optional<Books> save(Integer id,String name, String year, Integer authorId);

    //Optional<Books> save(ProductDto productDto);

    //Optional<Books> edit(Integer id, String name, Double price, Integer quantity, Long category, Long manufacturer);

    //Optional<Books> edit(Long id, ProductDto productDto);

    void deleteById(Integer id);
    void refreshMaterializedView();
    Optional<Books> save(BooksDto productDto);

}
