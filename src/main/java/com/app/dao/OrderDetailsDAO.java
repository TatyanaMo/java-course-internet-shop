package com.app.dao;

import com.app.model.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDetailsDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void storeNewOrderDetails(OrderDetails orderDetails) {
        jdbcTemplate.update("INSERT INTO order_details (book_id, order_id, quantity) VALUES (?, ?, ?)",
                orderDetails.getBookId(), orderDetails.getOrderId(), orderDetails.getQuantity());
    }

}
