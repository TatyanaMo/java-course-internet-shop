package com.app.dao;

import com.app.model.Book;
import com.app.model.BookType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookTypeDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void storeNewBookType(BookType bookType) {
        jdbcTemplate.update("INSERT INTO book_types (name) VALUES (?)", bookType.getName());
    }

    public List<BookType> getAllBookTypes() {
        RowMapper<BookType> rowMapper = (rs, rowNumber) -> mapType(rs);
        return jdbcTemplate.query("SELECT * FROM book_types ORDER BY book_types.id ASC", rowMapper);
    }

    private BookType mapType(ResultSet rs) throws SQLException {
        BookType bookType = new BookType();

        bookType.setId(rs.getLong("id"));
        bookType.setName(rs.getString("name"));
        return bookType;
    }
}
