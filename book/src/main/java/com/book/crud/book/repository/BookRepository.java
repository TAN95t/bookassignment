package com.book.crud.book.repository;

import com.book.crud.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    // Custom query methods can be defined here if needed
    // For example, find books by author or genre
    List<Book> findByAuthor(String author);
    List<Book> findByGenre(String genre);



}
