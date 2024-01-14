package com.app.model.enums;

public enum BookType {
    PAPERBOOK("paper book"),
    EBOOK("E-book"),
    AUDIO("Audio book");

    private String name;

    BookType(String type) {
        this.name = name();
    }

    @Override
    public String toString() {
        return name;
    }

}
