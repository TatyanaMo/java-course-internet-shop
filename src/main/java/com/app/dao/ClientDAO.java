package com.app.dao;

import com.app.model.Client;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClientDAO {
   @Autowired
   private JdbcTemplate jdbcTemplate;

   public void storeNewClient (Client client) {
       jdbcTemplate.update("INSERT INTO clients (name, surname, email, phone, shipping_address, password) VALUES (?, ?, ?, ?, ?, ?)",
               client.getName(), client.getSurname(), client.getEmail(), client.getPhone(), client.getShippingAddress(), client.getPassword());
   }

   public List<Client> getAllClients() {
       RowMapper<Client> rowMapper = (rs, rowNumber) -> mapClient(rs);
       return jdbcTemplate.query("SELECT * FROM clients ORDER BY clients.id ASC", rowMapper);
   }

   public List<Client> getClientByEmail(String email) {
       RowMapper<Client> rowMapper = (rs, rowNumber) -> mapClient(rs);
       return jdbcTemplate.query("SELECT * FROM clients WHERE email = ?", rowMapper, email);
   }

   private Client mapClient(ResultSet rs) throws SQLException {
       Client client = new Client();

       client.setId(rs.getLong("id"));
       client.setName(rs.getString("name"));
       client.setSurname(rs.getString("surname"));
       client.setEmail(rs.getString("email"));
       client.setPhone(rs.getString("phone"));
       client.setShippingAddress(rs.getString("shipping_address"));
       client.setPassword(rs.getString("password"));
       client.setRole(rs.getString("role"));
       return client;
   }
}
