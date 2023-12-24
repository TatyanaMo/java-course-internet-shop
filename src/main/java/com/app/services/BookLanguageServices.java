package com.app.services;

import com.app.dao.BookLanguageDAO;
import com.app.model.BookLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookLanguageServices {
    @Autowired
    BookLanguageDAO bookLanguageDAO;

    public void storeNewBookLanguage(BookLanguage bookLanguage) {
        //Field data validation here
        bookLanguageDAO.storeNewBookLanguage(bookLanguage);
    }
}
