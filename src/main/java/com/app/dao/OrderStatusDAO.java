package com.app.dao;

import com.app.model.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrderStatusDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void storeNewOrderStatus(OrderStatus orderStatus) {
        jdbcTemplate.update("INSERT INTO order_statuses (name) VALUES (?)", orderStatus.getName());
    }

    public List<OrderStatus> getAllOrderStatus() {
        RowMapper<OrderStatus> rowMapper = (rs, rowNumber) -> mapStatus(rs);
        return jdbcTemplate.query("SELECT * FROM order_statuses ORDER BY order_statuses.id ASC", rowMapper);
    }

    private OrderStatus mapStatus(ResultSet rs) throws SQLException {
        OrderStatus orderStatus = new OrderStatus();

        orderStatus.setId(rs.getLong("id"));
        orderStatus.setName(rs.getString("name"));
        return orderStatus;
    }
}
