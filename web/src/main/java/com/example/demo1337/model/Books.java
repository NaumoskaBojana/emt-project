package com.example.demo1337.model;

import com.example.demo1337.repo.AuthorRepository;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Books {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer book_id;


    String book_name;
    String book_year;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "author_id")
    private Author author;

    public Books(Integer book_id, String book_name, String book_year, Author author) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_year = book_year;
        this.author = author;
    }

    public Books(String name, String year, Author author) {
        this.book_name = name;
        this.book_year = year;
        this.author = author;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_year() {
        return book_year;
    }

    public void setBook_year(String book_year) {
        this.book_year = book_year;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
