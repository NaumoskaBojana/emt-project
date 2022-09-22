package com.example.demo1337.repo;

import com.example.demo1337.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {

    @Query(value ="select book_name from Books where book_name=?",nativeQuery = true)
    Optional<Books> findByName(String name);


    @Query(value ="delete from Books where book_name=?",nativeQuery = true)
    void deleteByName(String name);
}