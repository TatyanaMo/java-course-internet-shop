package com.app.controllers;

import com.app.model.Author;
import com.app.services.AdminServices;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorsRestController {
    @Autowired
    private AdminServices adminServices;

    @GetMapping("/api/_admin/allAuthors")
    public List<Author> getAuthors() {
        return adminServices.getAllAuthors();
    }

    @GetMapping("/api/_admin/allAuthors/{startsWith}")
    public List<Author> getAuthorsStartsWith(@PathVariable("startsWith") String startsWith) {
        return adminServices.getAllAuthorsStartingWith(startsWith);
    }
}
