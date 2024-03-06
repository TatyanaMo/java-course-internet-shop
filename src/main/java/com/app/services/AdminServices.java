package com.app.services;

import com.app.dao.*;
import com.app.model.*;
import com.app.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServices {

    @Autowired
    private ClientDAO clientDAO;

    public void storeNewClient(Client client) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(client.getPassword());
        client.setPassword(encodedPassword);

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

    @Autowired
    private BooksDAO booksDAO;

    public void storeNewBook(Book book) {
        booksDAO.storeNewBook(book);
    }

    @Autowired
    private BookReviewDAO bookReviewDAO;

    public void storeNewReview(BookReview bookReview) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();

        bookReview.setClientId(customUserDetails.getClient().getId());
        bookReviewDAO.storeNewReview(bookReview);
    }

    @Autowired
    private OrderDAO orderDAO;

    public void storeNewOrder(Order order) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();

        order.setClientId(customUserDetails.getClient().getId());
        orderDAO.storeNewOrder(order);
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

    public List<Book> getAllBooks() {
        //Field data validation here
        return booksDAO.getAllBooks();
    }

}
