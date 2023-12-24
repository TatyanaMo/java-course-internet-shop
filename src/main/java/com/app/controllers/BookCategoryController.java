package com.app.controllers;

import com.app.model.BookCategory;
import com.app.services.BookCategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookCategoryController {
    @Autowired
    private BookCategoryServices bookCategoryServices;

    @GetMapping("/category")
    public String getBookCategoryForm (Model model) {
        model.addAttribute("newBookCategory", new BookCategory());
        return "categoryForm";
    }
    @PostMapping("/category")
    public String storeNewBookCategory(@ModelAttribute BookCategory bookCategory, Model model) {
        bookCategoryServices.storeNewBookCategory(bookCategory);
        model.addAttribute("name", bookCategory.getName());
        return "categorySuccessfullyAdded";
    }
}
