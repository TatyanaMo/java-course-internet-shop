package com.app.controllers;

import com.app.model.BookLanguage;
import com.app.services.BookLanguageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookLanguageController {
    @Autowired
    private BookLanguageServices bookLanguageServices;

    @GetMapping("/language")
    public String getBookLanguageForm (Model model) {
        model.addAttribute("newBookLanguage", new BookLanguage());
        return "languageForm";
    }
    @PostMapping("/language")
    public String storeNewBookLanguage(@ModelAttribute BookLanguage bookLanguage, Model model) {
        bookLanguageServices.storeNewBookLanguage(bookLanguage);
        model.addAttribute("name", bookLanguage.getName());
        return "languageSuccessfullyAdded";
    }

}
