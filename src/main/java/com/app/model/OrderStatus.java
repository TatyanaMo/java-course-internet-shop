package com.app.model;

public class OrderStatus {

    private long id;
    private Enum statusName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Enum getStatusName() {
        return statusName;
    }

    public void setStatusName(Enum statusName) {
        this.statusName = statusName;
    }
}
