package com.svrn.bookstore.books;

public abstract class Book {
    private String title;
    private String author;
    private double price;
    private int pageNumber;

    public Book(String title, String author, int pageNumber, double price){
        this.title = title;
        this.author = author;
        this.pageNumber = pageNumber;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageNumber() {
        return pageNumber;
    }
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{"+
                "title: "+title+
                ", author: "+author+
                ", price: "+price+
                ", pages: "+pageNumber;
    }
}
