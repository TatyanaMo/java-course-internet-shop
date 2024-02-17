package com.app.controllers;


import com.app.model.*;
import com.app.services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    @Autowired
    private AdminServices adminServices;

    @GetMapping("/_admin/author")
    public String getAuthorsForm (Model model) {
        model.addAttribute("newAuthor", new Author());
        return "admin/authorForm";
    }

    @PostMapping("/_admin/author")
    public String storeNewAuthor(@ModelAttribute Author author, Model model) {
        adminServices.storeNewAuthor(author);
        model.addAttribute("name", author.getName());
        model.addAttribute("surname", author.getSurname());
        return "admin/authorSuccessfullyAdded";
    }

    @GetMapping("/_admin/category")
    public String getBookCategoryForm (Model model) {
        model.addAttribute("newBookCategory", new BookCategory());
        return "admin/categoryForm";
    }
    @PostMapping("/_admin/category")
    public String storeNewBookCategory(@ModelAttribute BookCategory bookCategory, Model model) {
        adminServices.storeNewBookCategory(bookCategory);
        model.addAttribute("name", bookCategory.getName());
        return "admin/categorySuccessfullyAdded";
    }

    @GetMapping("/_admin/type")
    public String getBookTypeForm (Model model) {
        model.addAttribute("newBookType", new BookType());
        return "admin/typeForm";
    }

    @PostMapping("/_admin/type")
    public String storeNewBookType(@ModelAttribute BookType bookType, Model model) {
        adminServices.storeNewBookType(bookType);
        model.addAttribute("name", bookType.getName());
        return "admin/typeSuccessfullyAdded";
    }

    @GetMapping("/_admin/language")
    public String getBookLanguageForm (Model model) {
        model.addAttribute("newBookLanguage", new BookLanguage());
        return "admin/languageForm";
    }
    @PostMapping("/_admin/language")
    public String storeNewBookLanguage(@ModelAttribute BookLanguage bookLanguage, Model model) {
        adminServices.storeNewBookLanguage(bookLanguage);
        model.addAttribute("name", bookLanguage.getName());
        return "admin/languageSuccessfullyAdded";
    }

    @GetMapping("/_admin/status")
    public String getOrderStatusForm (Model model) {
        model.addAttribute("newOrderStatus", new OrderStatus());
        return "admin/statusForm";
    }

    @PostMapping("/_admin/status")
    public String storeNewOrderStatus(@ModelAttribute OrderStatus orderStatus, Model model) {
        adminServices.storeNewOrderStatus(orderStatus);
        model.addAttribute("name", orderStatus.getName());
        return "admin/statusSuccessfullyAdded";
    }

    @GetMapping("/_admin/allClients")
    public String getAllClients(Model model) {
        model.addAttribute("clients", adminServices.getAllClients());
        return "admin/allClients";
    }

    @GetMapping("/_admin/allAuthors")
    public String getAllAuthors(Model model) {
        model.addAttribute("authors", adminServices.getAllAuthors());
        return "admin/allAuthors";
    }

    @GetMapping("/_admin/allCategories")
    public String getAllBookCategories(Model model) {
        model.addAttribute("categories", adminServices.getAllCategories());
        return "admin/allCategories";
    }

    @GetMapping("/_admin/allLanguages")
    public String getAllBookLanguages(Model model) {
        model.addAttribute("languages", adminServices.getAllLanguages());
        return "admin/allLanguages";
    }

    @GetMapping("/_admin/allTypes")
    public String getAllBookTypes(Model model) {
        model.addAttribute("types", adminServices.getAllTypes());
        return "admin/allTypes";
    }

    @GetMapping("/_admin/allStatuses")
    public String getAllOrderStatuses(Model model) {
        model.addAttribute("statuses", adminServices.getAllStatuses());
        return "admin/allStatuses";
    }
}