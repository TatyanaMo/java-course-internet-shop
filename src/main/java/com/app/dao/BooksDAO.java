package com.app.dao;

import com.app.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BooksDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void storeNewBook(Book book) {
        jdbcTemplate.update("INSERT INTO books (name, price, author_id, category_id, language_id, type_id, year)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?)", book.getBookName(), book.getPrice(), book.getAuthorId(), book.getCategoryId(),
        book.getLanguageId(), book.getTypeId(), book.getYear());
    }

    public List<Book> getAllBooks() {
        RowMapper<Book> rowMapper = (rs, rowNumber) -> mapBook(rs);
        return jdbcTemplate.query("SELECT * FROM books", rowMapper);
    }

    private Book mapBook(ResultSet rs) throws SQLException {
        Book book = new Book();

        book.setId(rs.getLong("id"));
        book.setBookName(rs.getString("name"));
        return book;
    }
}
