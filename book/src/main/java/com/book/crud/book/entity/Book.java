package com.book.crud.book.entity;


/*Book Entity: Create an entity class for a Book with the following fields:

id (Long): The unique identifier for the book (auto-generated).
title (String): The title of the book.
author (String): The author of the book.
publishedYear (Integer): The year the book was published.
genre (String): The genre of the book.*/

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer publishedYear;
    private String author;
    private String genre;

    public Book(Long id, String title, Integer publishedYear, String author, String genre) {
        this.id = id;
        this.title = title;
        this.publishedYear = publishedYear;
        this.author = author;
        this.genre = genre;
    }

    public Book() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
