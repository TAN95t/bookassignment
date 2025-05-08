package com.book.crud.book.service;

import com.book.crud.book.dto.BookResponseDTO;

import java.util.List;

public interface BookService {

    List<BookResponseDTO> getAllBooks();
    BookResponseDTO getBookById(Long id);
    BookResponseDTO createBook(BookResponseDTO bookRequestDTO);
    BookResponseDTO updateBook(Long id, BookResponseDTO bookRequestDTO);
    void deleteBook(Long id);

}
