package com.app.controllers;

import com.app.model.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
   @GetMapping("/registration")
   public String getRegistrationForm (Model model) {
       model.addAttribute("newClient", new Client());
       return "registration";
   }

   @PostMapping("/registration")
    public String saveNewClient(@ModelAttribute Client client, Model model) {
       model.addAttribute("name", client.getName());
       model.addAttribute("surname", client.getSurname());
       return "successRegistration";
   }
}
