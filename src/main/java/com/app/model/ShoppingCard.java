package com.app.model;

import java.math.BigDecimal;

public class ShoppingCard {
    private String clientId;
    private String bookName;
    private int booksQuantities;
    private BigDecimal totalCost;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBooksQuantities() {
        return booksQuantities;
    }

    public void setBooksQuantities(int booksQuantities) {
        this.booksQuantities = booksQuantities;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }
}
