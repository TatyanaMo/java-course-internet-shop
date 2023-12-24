package com.app.controllers;

import com.app.model.BookType;
import com.app.services.BookTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookTypeController {
    @Autowired
    BookTypeServices bookTypeServices;

    @GetMapping("/type")
    public String getBookTypeForm (Model model) {
        model.addAttribute("newBookType", new BookType());
        return "typeForm";
    }

    @PostMapping("/type")
    public String storeNewBookType(@ModelAttribute BookType bookType, Model model) {
        bookTypeServices.storeNewBookType(bookType);
        model.addAttribute("name", bookType.getName());
        return "typeSuccessfullyAdded";
    }

}
