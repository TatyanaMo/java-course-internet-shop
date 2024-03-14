package com.app.model;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    private long id;
//    private long clientId;
    private BigDecimal totalPrice;
//    private long orderStatusId;
    private Client client;
    private OrderStatus orderStatus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public long getClientId() {
//        return clientId;
//    }
//
//    public void setClientId(long clientId) {
//        this.clientId = clientId;
//    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

//    public long getOrderStatusId() {
//        return orderStatusId;
//    }
//
//    public void setOrderStatusId(long orderStatusId) {
//        this.orderStatusId = orderStatusId;
//    }


    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
