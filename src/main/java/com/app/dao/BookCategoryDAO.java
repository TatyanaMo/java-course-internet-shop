package com.app.dao;

import com.app.model.BookCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookCategoryDAO {
   @Autowired
   private JdbcTemplate jdbcTemplate;
   public void storeNewBookCategory(BookCategory bookCategory) {
       jdbcTemplate.update("INSERT INTO book_categories (name) VALUES (?)", bookCategory.getName());
   }

   public List<BookCategory> getAllBookCategories() {
       RowMapper<BookCategory> rowMapper = (rs, rowNumber) -> mapCategory(rs);
       return jdbcTemplate.query("SELECT * FROM book_categories", rowMapper);
   }

   private BookCategory mapCategory(ResultSet rs) throws SQLException {
       BookCategory bookCategory = new BookCategory();

       bookCategory.setId(rs.getLong("id"));
       bookCategory.setName(rs.getString("name"));
       return bookCategory;
   }
}
