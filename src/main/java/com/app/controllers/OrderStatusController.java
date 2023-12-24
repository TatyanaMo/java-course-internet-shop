package com.app.controllers;

import com.app.model.OrderStatus;
import com.app.services.OrderStatusServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderStatusController {
    @Autowired
    OrderStatusServices orderStatusServices;

    @GetMapping("/status")
    public String getOrderStatusForm (Model model) {
        model.addAttribute("newOrderStatus", new OrderStatus());
        return "statusForm";
    }

    @PostMapping("/status")
    public String storeNewOrderStatus(@ModelAttribute OrderStatus orderStatus, Model model) {
        orderStatusServices.storeNewOrderStatus(orderStatus);
        model.addAttribute("name", orderStatus.getName());
        return "statusSuccessfullyAdded";
    }
}
