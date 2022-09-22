package com.example.demo1337.web.controller;

import com.example.demo1337.model.Author;
import com.example.demo1337.model.Books;
import com.example.demo1337.repo.AuthorRepository;
import com.example.demo1337.service.BooksService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {


    private final BooksService booksService;
    private final AuthorRepository authorRepository;

    public BookController(BooksService booksService, AuthorRepository authorRepository) {
        this.booksService = booksService;
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public String getProductPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Books> products = this.booksService.findAll();
        model.addAttribute("products", products);
        model.addAttribute("bodyContent", "products");
        return "master-template";
    }


    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        this.booksService.deleteById(id);
        return "redirect:/books";
    }

    @GetMapping("/add-form")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addProductPage(Model model) {
        List<Author> authors = this.authorRepository.findAll();
        model.addAttribute("authors", authors);
        model.addAttribute("bodyContent", "addBook");
        return "master-template";
    }

    @PostMapping("/add")
    public String saveProduct(
            @RequestParam(required = false) Integer book_id,
            @RequestParam String book_name,
            @RequestParam String book_year,
            @RequestParam Integer author_id
            ) {

            this.booksService.save(book_id,book_name, book_year, author_id);

        return "redirect:/books";
    }


}
