package com.app.services;

import com.app.dao.OrderStatusDAO;
import com.app.model.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderStatusServices {
    @Autowired
    private OrderStatusDAO orderStatusDAO;

    public void storeNewOrderStatus(OrderStatus orderStatus) {
        //Field data validation here
        orderStatusDAO.storeNewOrderStatus(orderStatus);
    }
}
