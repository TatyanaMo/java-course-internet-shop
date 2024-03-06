package com.app.dao;

import com.app.model.BookReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookReviewDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void  storeNewReview(BookReview bookReview) {
        jdbcTemplate.update("INSERT INTO book_reviews (client_id, book_id, review_content) VALUES (?, ?, ?)",
                bookReview.getClientId(), bookReview.getBookId(), bookReview.getReviewContent());
    }

}
