package com.app.controllers;

import com.app.model.Client;
import com.app.services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private AdminServices adminServices;

    @GetMapping("/registration")
    public String getRegistrationForm(Model model) {
        model.addAttribute("newClient", new Client());
        return "admin/registration";
    }

    @PostMapping("/registration")
    public String saveNewClient(@ModelAttribute Client client, Model model) {
        adminServices.storeNewClient(client);
        model.addAttribute("name", client.getName());
        model.addAttribute("surname", client.getSurname());
        return "admin/successRegistration";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "admin/login";
    }
}
