package com.restaurant.ss6.repository;

import com.restaurant.ss6.entity.Book;

import java.util.List;

public interface BookRepository {
List<Book> findAll();
Book findById(int id);
}
