package com.app.dao;

import com.app.model.BookType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookTypeDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void storeNewBookType(BookType bookType) {
        jdbcTemplate.update("INSERT INTO book_types (name) VALUES (?)", bookType.getName());
    }
}
