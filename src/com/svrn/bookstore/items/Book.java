package com.svrn.bookstore.items;

import java.util.Objects;

public class Book extends Item implements Comparable<Book>{
    private String title;
    private String author;
    private int pageNumber;

    public Book(String title, String author, int pageNumber, double price) {
        super(price);
        this.title = title;
        this.author = author;
        this.pageNumber = pageNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    @Override
    public String toString() {
        return "Book{"+
                "ID: " + getID()+
                ", title: "+title+
                ", author: "+author+
                ", pages: "+pageNumber+
                ", price: "+getPrice()+
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass()!=o.getClass()) return false;
        Book book = (Book) o;
        return title.equals(book.getTitle()) &&
                author.equals(book.getAuthor()) &&
                getPrice() == book.getPrice() &&
                pageNumber == book.getPageNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), title, author, getPrice(), pageNumber);
    }

    @Override
    public int compareTo(Book book) {
        return title.compareTo(book.getTitle());
    }
}