package com.app.security;

import com.app.dao.ClientDAO;
import com.app.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private ClientDAO clientDAO;

    @Override
    public UserDetails loadUserByUsername(String username) {
        List<Client> clients = clientDAO.getClientByEmail(username);

        if(clients.isEmpty()) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }

        return new CustomUserDetails(clients.get(0));
    }
}
