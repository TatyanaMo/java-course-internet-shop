package com.app.dao;

import com.app.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AuthorDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void storeNewAuthor(Author author) {
        jdbcTemplate.update("INSERT INTO authors (name, surname) VALUES (?, ?)", author.getName(), author.getSurname());
    }

    public List<Author> getAllAuthors() {
        RowMapper<Author> rowMapper = (rs, rowNumber) -> mapAuthor(rs);
        return jdbcTemplate.query("SELECT * FROM authors ORDER BY authors.id ASC", rowMapper);
    }

    private Author mapAuthor(ResultSet rs) throws SQLException {
        Author author = new Author();

        author.setId(rs.getLong("id"));
        author.setName(rs.getString("name"));
        author.setSurname(rs.getString("surname"));
        return author;
    }

    public List<Author> getAllAuthorsStartingWith(String startsWith) {
        RowMapper<Author> rowMapper = (rs, rowNumber) -> mapAuthor(rs);
        return jdbcTemplate.query("SELECT * FROM authors WHERE name LIKE CONCAT(?,'%')", rowMapper, startsWith);
    }
}
