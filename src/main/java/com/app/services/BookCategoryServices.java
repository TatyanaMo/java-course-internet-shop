package com.app.services;

import com.app.dao.BookCategoryDAO;
import com.app.model.BookCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookCategoryServices {
    @Autowired
    private BookCategoryDAO bookCategoryDAO;

    public void storeNewBookCategory(BookCategory bookCategory) {
        //Field data validation here
        bookCategoryDAO.storeNewBookCategory(bookCategory);
    }
}

