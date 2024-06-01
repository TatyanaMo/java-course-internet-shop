package com.app.services;

import com.app.dao.*;
import com.app.model.*;
import com.app.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    public Client getCurrentClient() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customClient = (CustomUserDetails) authentication.getPrincipal();

        return clientDAO.getClientById(customClient.getClient().getId());
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

    public BigDecimal getBookPriceById(long bookId) {
        return booksDAO.getBookPriceById(bookId);
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
        // Retrieve the book price based on the book ID in the order
        long bookId = order.getBookId();
        BigDecimal bookPrice = booksDAO.getBookPriceById(bookId);
        // Calculate the total price based on the book price and quantity
        int quantity = order.getQuantity();
        BigDecimal totalPrice = bookPrice.multiply(BigDecimal.valueOf(quantity));
        order.setTotalPrice(totalPrice);
        // Set the order status to "New"
        OrderStatus newStatus = orderStatusDAO.getOrderStatusByName("New");
        order.setOrderStatus(newStatus);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();

        Client client = new Client();
        client.setId(customUserDetails.getClient().getId());
        order.setClient(client);
        orderDAO.storeNewOrder(order);
    }

    public List<Order> getOrdersByClient(long clientId) {
        return orderDAO.getOrdersByClient(clientId);

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

    public List<Book> getAllBooksStartingWith(String startsWith) {
        return booksDAO.getAllBooksStartingWith(startsWith);
    }

    public List<Author> getAllAuthorsStartingWith(String startsWith) {
        return authorDAO.getAllAuthorsStartingWith(startsWith);
    }

    public List<Order> getAllOrders() {
        //Field data validation here
        return orderDAO.getAllOrders();
    }

    public Author getAuthorById(long id) {
        return authorDAO.getAuthorById(id);
    }

    public void updateAuthor(Author author) {
        authorDAO.updateAuthor(author);
    }

}
