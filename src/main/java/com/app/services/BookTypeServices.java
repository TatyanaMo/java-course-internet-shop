package com.app.services;

import com.app.dao.BookTypeDAO;
import com.app.model.BookType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookTypeServices {
    @Autowired
    BookTypeDAO bookTypeDAO;

    public void storeNewBookType(BookType bookType) {
        //Field data validation here
        bookTypeDAO.storeNewBookType(bookType);
    }
}
