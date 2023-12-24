package com.app.controllers;


import com.app.model.Author;
import com.app.services.AuthorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {
    @Autowired
    private AuthorServices authorServices;

    @GetMapping("/author")
    public String getAuthorsForm (Model model) {
        model.addAttribute("newAuthor", new Author());
        return "authorForm";
    }

    @PostMapping("/author")
    public String storeNewAuthor(@ModelAttribute Author author, Model model) {
        authorServices.storeNewAuthor(author);
        model.addAttribute("name", author.getName());
        model.addAttribute("surname", author.getSurname());
        return "authorSuccessfullyAdded";
    }

}
