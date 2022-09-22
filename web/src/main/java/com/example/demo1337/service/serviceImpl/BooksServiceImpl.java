package com.example.demo1337.service.serviceImpl;

import com.example.demo1337.model.Author;
import com.example.demo1337.model.Books;
import com.example.demo1337.model.dto.BooksDto;
import com.example.demo1337.model.events.ProductCreatedEvent;
import com.example.demo1337.repo.AuthorRepository;
import com.example.demo1337.repo.BooksRepository;
import com.example.demo1337.service.BooksService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BooksServiceImpl implements BooksService {

    private final BooksRepository booksRepository;
    private final AuthorRepository authorRepository;
    private ApplicationEventPublisher applicationEventPublisher;

    public BooksServiceImpl(BooksRepository booksRepository, AuthorRepository authorRepository) {
        this.booksRepository = booksRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Books> findAll() {
        return this.booksRepository.findAll();
    }

    @Override
    public Optional<Books> findById(Integer id) {
        return this.booksRepository.findById(id);
    }

    @Override
    public Optional<Books> findByName(String name) {
        return this.booksRepository.findByName(name);
    }

    @Override
    @Transactional
    public Optional<Books> save(Integer id,String name, String year, Integer authorId) {
        Author author = this.authorRepository.findById(authorId).get();
        Books book = new Books(id,name,year,author);
       this.booksRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void deleteById(Integer id) {
        Books book = this.booksRepository.findById(id).get();
        this.booksRepository.delete(book);
    }

    @Override
    public void refreshMaterializedView() {

    }

    @Override
    public Optional<Books> save(BooksDto productDto) {
        Author author = this.authorRepository.findById(productDto.getAuthor()).get();

        Books product = new Books(productDto.getId(), productDto.getName(), productDto.getYear(), author);
        this.booksRepository.save(product);
        //this.refreshMaterializedView();

        //this.applicationEventPublisher.publishEvent(new ProductCreatedEvent(product));
        return Optional.of(product);

    }

}
