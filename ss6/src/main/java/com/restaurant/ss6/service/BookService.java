package com.restaurant.ss6.service;

import com.restaurant.ss6.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();
    Book getBook(int id);
}
