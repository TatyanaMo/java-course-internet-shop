package com.app.model;

public class BookType {

    private long id;
    private Enum typeName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Enum getTypeName() {
        return typeName;
    }

    public void setTypeName(Enum typeName) {
        this.typeName = typeName;
    }
}
