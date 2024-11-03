package com.svrn.bookstore.books;

import com.svrn.bookstore.orders.Order;

import java.util.Objects;

public class Ebook extends Book{

    private double fileSize;

    public Ebook(String title, String author, int pageNumber, double price) {
        super(title, author, pageNumber, price);
    }

    public Ebook(String title, String author, int pageNumber, double price, double fileSize) {
        this(title, author, pageNumber, price);
        this.fileSize = fileSize;
    }

    public double getFileSize() {
        return fileSize;
    }
    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", type: Ebook"+
                ", fileSize: " + fileSize+
                "}.";
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            Ebook ebook = (Ebook) o;
            return fileSize == ebook.getFileSize();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fileSize);
    }
}
