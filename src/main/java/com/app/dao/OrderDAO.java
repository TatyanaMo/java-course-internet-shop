package com.app.dao;

import com.app.model.Client;
import com.app.model.Order;
import com.app.model.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrderDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void storeNewOrder(Order order) {
        jdbcTemplate.update("INSERT INTO orders (client_id, order_status_id) VALUES (?, ?)",
                order.getClient().getId(), order.getOrderStatus().getId());
    }

    public List<Order> getAllOrders() {
        RowMapper<Order> rowMapper = (rs, rowNumber) -> mapOrder(rs);
        return jdbcTemplate.query("SELECT c.id AS cid, c.name, c.surname, o.id AS oid, o.total_price, o.order_status_id, s.id AS sid, s.name AS sname " +
                "FROM orders o " +
                "INNER JOIN clients c ON o.client_id = c.id " +
                "INNER JOIN order_statuses s ON o.order_status_id = s.id ", rowMapper);
    }

    public List<Order> getOrdersByClient(long clientId) {
        RowMapper<Order> rowMapper = (rs, rowNumber) -> mapOrder(rs);
        return jdbcTemplate.query("SELECT c.id AS cid, c.name, c.surname, o.id AS oid, o.total_price, o.order_status_id, s.id AS sid, s.name AS sname " +
                "FROM orders o " +
                "INNER JOIN clients c ON o.client_id = c.id " +
                "INNER JOIN order_statuses s ON o.order_status_id = s.id " +
                "WHERE client_id = ?", rowMapper, clientId);
    }

    private Order mapOrder(ResultSet rs) throws SQLException {
        Client client = new Client();
        client.setId(rs.getLong("cid"));
        client.setName(rs.getString("name"));
        client.setSurname(rs.getString("surname"));

        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setId(rs.getLong("sid"));
        orderStatus.setName(rs.getString("sname"));

        Order order = new Order();

        order.setId(rs.getLong("oid"));
//        order.setClientId(rs.getLong("client_id"));
        order.setClient(client);
        order.setTotalPrice(rs.getBigDecimal("total_price"));
//        order.setOrderStatusId(rs.getLong("order_status_id"));
        order.setOrderStatus(orderStatus);
        return order;
    }
}
