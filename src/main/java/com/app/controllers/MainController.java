package com.app.controllers;

import com.app.services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private AdminServices adminServices;

    @GetMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("clientname", adminServices.getCurrentClient().getName());
        return "homePage";
    }
}
