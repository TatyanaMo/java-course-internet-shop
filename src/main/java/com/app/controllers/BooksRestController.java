package com.app.controllers;

import com.app.model.Book;
import com.app.services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BooksRestController {
    @Autowired
    private AdminServices adminServices;

    @GetMapping("/api/books")
    public List<Book> getBooks() {
        return adminServices.getAllBooks();
    }

    @GetMapping("/api/books/{startsWith}")
    public List<Book> getBooksStartsWith(@PathVariable("startsWith") String startsWith) {
        return adminServices.getAllBooksStartingWith(startsWith);
    }

}
