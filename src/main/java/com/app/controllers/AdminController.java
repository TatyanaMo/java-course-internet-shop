package com.app.controllers;


import com.app.model.*;
import com.app.services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

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

    @GetMapping("/_admin/author/{id}")
    public String showAuthors(@PathVariable("id") long id, Model model) {
        model.addAttribute("author", adminServices.getAuthorById(id));
        return "admin/author";
    }

    @GetMapping("/_admin/author/edit/{id}")
    public String showEditAuthorForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("author", adminServices.getAuthorById(id));
        return "admin/editAuthor";
    }

    @PostMapping("/_admin/author/edit/{id}")
    public String editAuthor(@ModelAttribute Author author, @PathVariable("id") long id) {
       author.setId(id);
       adminServices.updateAuthor(author);
       return "redirect:/_admin/allAuthors";
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


    @GetMapping("/_admin/newBook")
    public String getNewBook(Model model) {
        model.addAttribute("newBook", new Book());
        model.addAttribute("categories", adminServices.getAllCategories());
        model.addAttribute("types", adminServices.getAllTypes());
        model.addAttribute("languages", adminServices.getAllLanguages());
        model.addAttribute("authors", adminServices.getAllAuthors());
        return "admin/newBook";
    }

    @PostMapping("/_admin/newBook")
    public String storeNewBook(@ModelAttribute Book book) {
        adminServices.storeNewBook(book);
        return "admin/bookSuccessfullyAdded";
    }

    @GetMapping("/_admin/newReview")
    public String getNewReview(Model model) {
        model.addAttribute("newReview", new BookReview());
        model.addAttribute("books", adminServices.getAllBooks());
        return "admin/newReview";
    }

    @PostMapping("/_admin/newReview")
    public String storeNewReview(@ModelAttribute BookReview bookReview) {
        adminServices.storeNewReview(bookReview);
        return "admin/reviewSuccessfullyAdded";
    }

    @GetMapping("/_admin/newOrder")
    public String getNewOrder(Model model) {
        model.addAttribute("newOrder", new Order());
        model.addAttribute("orderStatuses", adminServices.getAllStatuses());
        model.addAttribute("books", adminServices.getAllBooks());
        return "admin/newOrder";
    }

    @PostMapping("/_admin/newOrder")
    public String storeNewOrder(@ModelAttribute Order order) {
        adminServices.storeNewOrder(order);
        return "admin/orderSuccessfullyAdded";
    }

    @GetMapping("/_admin/client/{id}")
    public String openClient(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("orders",adminServices.getOrdersByClient(id));
        return "/admin/order";
    }

    @GetMapping("/_admin/avatar-upload")
    public String uploadAvatar() {
        return "/admin/avatarUpload";
    }


    @GetMapping("/_admin/{bookId}/price")
    public ResponseEntity<BigDecimal> getBookPrice(@PathVariable("bookId") long bookId) {
        BigDecimal price = adminServices.getBookPriceById(bookId);
        if (price != null) {
            return ResponseEntity.ok(price);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
