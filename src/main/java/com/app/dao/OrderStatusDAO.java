package com.app.dao;

import com.app.model.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderStatusDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void storeNewOrderStatus(OrderStatus orderStatus) {
        jdbcTemplate.update("INSERT INTO order_statuses (name) VALUES (?)", orderStatus.getName());
    }
}
