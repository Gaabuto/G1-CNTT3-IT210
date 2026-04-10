package com.restaurant.ss6.controller;

import com.restaurant.ss6.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/","/books"})
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("listBooks", bookService.getBooks());
        return "list-books";
    }
    @GetMapping("/detail")
    public String details(@RequestParam("id")Integer id, Model model) {
        model.addAttribute("book", bookService.getBook(id));
        return "details";
    }
}
