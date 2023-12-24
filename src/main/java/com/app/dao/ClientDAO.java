package com.app.dao;

import com.app.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDAO {
   @Autowired
   private JdbcTemplate jdbcTemplate;

   public void storeNewClient (Client client) {
       jdbcTemplate.update("INSERT INTO clients (name, surname, email, phone, shipping_address, password) VALUES (?, ?, ?, ?, ?, ?)",
               client.getName(), client.getSurname(), client.getEmail(), client.getPhone(), client.getShippingAddress(), client.getPassword());
   }
}
