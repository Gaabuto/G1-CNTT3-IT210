package com.restaurant.ss6.repository.impl;

import com.restaurant.ss6.entity.Book;
import com.restaurant.ss6.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private List<Book> books;

    public BookRepositoryImpl(List<Book> books) {
    books = new ArrayList<Book>();

try{
    books.add(new Book(1,"Giông tố", "Vũ Trọng Phụng", 360000));
    books.add(new Book(2,"Số Đỏ", "Vũ Trọng Phụng", 135000));
    books.add(new Book(3,"Vỡ đê", "Vũ Trọng Phụng", 70000));
    books.add(new Book(4,"Làm Đĩ", "Vũ Trọng Phụng", 210000));



}catch(Exception e){
    e.printStackTrace();
}
    }
    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public Book findById(int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }
}