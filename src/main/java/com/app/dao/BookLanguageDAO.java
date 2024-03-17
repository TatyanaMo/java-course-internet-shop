package com.app.dao;

import com.app.model.Book;
import com.app.model.BookLanguage;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookLanguageDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void storeNewBookLanguage(BookLanguage bookLanguage) {
        jdbcTemplate.update("INSERT INTO book_languages (name) VALUES (?)", bookLanguage.getName());
    }

    public List<BookLanguage> getAllBookLanguages() {
        RowMapper<BookLanguage> rowMapper = (rs, rowNumber) -> mapLanguage(rs);
        return jdbcTemplate.query("SELECT * FROM book_languages ORDER BY book_languages.id ASC", rowMapper);
    }

    private BookLanguage mapLanguage(ResultSet rs) throws SQLException {
        BookLanguage bookLanguage = new BookLanguage();

        bookLanguage.setId(rs.getLong("id"));
        bookLanguage.setName(rs.getString("name"));
        return bookLanguage;
    }
}
