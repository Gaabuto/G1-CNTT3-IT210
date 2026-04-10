package com.restaurant.ss6.service.impl;

import com.restaurant.ss6.entity.Book;
import com.restaurant.ss6.repository.BookRepository;
import com.restaurant.ss6.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServcieImpl implements BookService {
    BookRepository bookRepository;
    public BookServcieImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(int id) {
        return bookRepository.findById(id);
    }
}
