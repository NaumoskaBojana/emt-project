package com.example.demo1337.model.dto;

import lombok.Data;

@Data
public class BooksDto {

    private Integer id;

    private String name;

    private String year;

    private Integer author;

    public BooksDto() {
    }

    public BooksDto(Integer id,String name, String year, Integer author) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.author = author;
    }
}

