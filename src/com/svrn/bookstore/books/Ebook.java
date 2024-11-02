package com.svrn.bookstore.books;

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
}
