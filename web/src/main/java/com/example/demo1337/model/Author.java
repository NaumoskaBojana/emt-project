package com.example.demo1337.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer author_id;


    String author_name;
    String author_surname;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Users user_id;

    public Author(Integer author_id, String author_name, String author_surname, Users user_id) {
        this.author_id = author_id;
        this.author_name = author_name;
        this.author_surname = author_surname;
        this.user_id = user_id;
    }

}
