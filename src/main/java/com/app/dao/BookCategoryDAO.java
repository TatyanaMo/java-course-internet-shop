package com.app.dao;

import com.app.model.BookCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookCategoryDAO {
   @Autowired
   private JdbcTemplate jdbcTemplate;
   public void storeNewBookCategory(BookCategory bookCategory) {
       jdbcTemplate.update("INSERT INTO book_categories (name) VALUES (?)", bookCategory.getName());
   }
}
