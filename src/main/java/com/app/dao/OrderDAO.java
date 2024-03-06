package com.app.dao;

import com.app.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void storeNewOrder(Order order) {
        jdbcTemplate.update("INSERT INTO orders (client_id, order_status_id) VALUES (?, ?)",
                order.getClientId(), order.getOrderStatusId());
    }
}
