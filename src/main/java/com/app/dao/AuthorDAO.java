package com.app.dao;

import com.app.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void storeNewAuthor(Author author) {
        jdbcTemplate.update("INSERT INTO authors (name, surname) VALUES (?, ?)", author.getName(), author.getSurname());
    }
}
