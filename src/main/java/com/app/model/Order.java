package com.app.model;

import java.math.BigDecimal;

public class Order {

    private long orderId;
    private long bookId;
    private long clientId;
    private int booksQuantity;
    private BigDecimal orderCost;
    private String orderStatus;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public int getBooksQuantity() {
        return booksQuantity;
    }

    public void setBooksQuantity(int booksQuantity) {
        this.booksQuantity = booksQuantity;
    }

    public BigDecimal getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(BigDecimal orderCost) {
        this.orderCost = orderCost;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
