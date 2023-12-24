package com.app.dao;

import com.app.model.BookLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookLanguageDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void storeNewBookLanguage(BookLanguage bookLanguage) {
        jdbcTemplate.update("INSERT INTO book_languages (name) VALUES (?)", bookLanguage.getName());
    }
}
