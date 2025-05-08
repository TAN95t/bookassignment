package com.book.crud.book.service;

import com.book.crud.book.dto.BookResponseDTO;
import com.book.crud.book.entity.Book;
import com.book.crud.book.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<BookResponseDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(book -> modelMapper.map(book, BookResponseDTO.class))
                .toList();
    }

    @Override
    public BookResponseDTO getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        return modelMapper.map(book, BookResponseDTO.class);
    }

    @Override
    public BookResponseDTO createBook(BookResponseDTO bookRequestDTO) {
        Book book = modelMapper.map(bookRequestDTO, Book.class);
        return modelMapper.map(bookRepository.save(book), BookResponseDTO.class);
    }

    @Override
    public BookResponseDTO updateBook(Long id, BookResponseDTO bookRequestDTO) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

        book.setTitle(bookRequestDTO.getTitle());
        book.setAuthor(bookRequestDTO.getAuthor());
        book.setPublishedYear(bookRequestDTO.getPublishedYear());
        book.setGenre(bookRequestDTO.getGenre());
        return modelMapper.map(bookRepository.save(book), BookResponseDTO.class);
    }

    @Override
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        bookRepository.delete(book);
    }
}
