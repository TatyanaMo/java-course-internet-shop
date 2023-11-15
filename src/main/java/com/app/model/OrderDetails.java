package com.app.model;

import java.math.BigDecimal;

public class OrderDetails {

    private long id;
    private long bookId;
    private long orderId;
    private int quantity;
    private BigDecimal orderedBookPrice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getOrderedBookPrice() {
        return orderedBookPrice;
    }

    public void setOrderedBookPrice(BigDecimal orderedBookPrice) {
        this.orderedBookPrice = orderedBookPrice;
    }
}
