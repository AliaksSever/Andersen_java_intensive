package com.svrn.bookstore.books;

import java.util.Objects;

public abstract class Book implements Comparable<Book>{
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
    public void setPrice(double price) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass()!=o.getClass()) return false;
        Book book = (Book) o;
        return title.equals(book.getTitle()) &&
                author.equals(book.getAuthor()) &&
                price == book.getPrice() &&
                pageNumber == book.pageNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, price, pageNumber);
    }

    @Override
    public int compareTo(Book book) {
        return toString().compareTo(book.toString());
    }
}
