package com.app.controllers;

import com.app.services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookListController {

    @Autowired
    private AdminServices adminServices;

    @GetMapping("/allBooks")
    public String getAllBooks(Model model) {
        model.addAttribute("books", adminServices.getAllBooks());
        return "allBooks";
    }


}
