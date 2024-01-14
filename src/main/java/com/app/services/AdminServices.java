package com.app.services;

import com.app.dao.*;
import com.app.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServices {

    @Autowired
    private ClientDAO clientDAO;

    public void storeNewClient(Client client) {
        //Fields data validation here
        clientDAO.storeNewClient(client);
    }

   @Autowired
   private AuthorDAO authorDAO;

   public void storeNewAuthor(Author author) {
       //Field data validation here
       authorDAO.storeNewAuthor(author);
   }

   @Autowired
    private BookCategoryDAO bookCategoryDAO;

    public void storeNewBookCategory(BookCategory bookCategory) {
        //Field data validation here
        bookCategoryDAO.storeNewBookCategory(bookCategory);
    }

    @Autowired
    private BookTypeDAO bookTypeDAO;

    public void storeNewBookType(BookType bookType) {
        //Field data validation here
        bookTypeDAO.storeNewBookType(bookType);
    }

    @Autowired
    private BookLanguageDAO bookLanguageDAO;

    public void storeNewBookLanguage(BookLanguage bookLanguage) {
        //Field data validation here
        bookLanguageDAO.storeNewBookLanguage(bookLanguage);
    }

    @Autowired
    private OrderStatusDAO orderStatusDAO;

    public void storeNewOrderStatus(OrderStatus orderStatus) {
        //Field data validation here
        orderStatusDAO.storeNewOrderStatus(orderStatus);
    }


    public List<Client> getAllClients() {
        //Field data validation here
        return clientDAO.getAllClients();
    }

    public List<Author> getAllAuthors() {
        //Field data validation here
        return authorDAO.getAllAuthors();
    }

    public List<BookCategory> getAllCategories() {
        //Field data validation here
        return bookCategoryDAO.getAllBookCategories();
    }

    public List<BookLanguage> getAllLanguages() {
        //Field data validation here
        return bookLanguageDAO.getAllBookLanguages();
    }

    public List<BookType> getAllTypes() {
        //Field data validation here
        return bookTypeDAO.getAllBookTypes();
    }

    public List<OrderStatus> getAllStatuses() {
        //Field data validation here
        return orderStatusDAO.getAllOrderStatus();
    }
}
