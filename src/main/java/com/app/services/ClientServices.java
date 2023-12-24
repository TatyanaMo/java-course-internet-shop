package com.app.services;

import com.app.dao.ClientDAO;
import com.app.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServices {
    @Autowired
    private ClientDAO clientDAO;

    public void storeNewClient(Client client) {
        //Fields data validation here
        clientDAO.storeNewClient(client);
    }
}
