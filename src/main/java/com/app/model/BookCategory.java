package com.app.model;

public class BookCategory {

    private long id;
    private Enum categoryName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Enum getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(Enum categoryName) {
        this.categoryName = categoryName;
    }
}
