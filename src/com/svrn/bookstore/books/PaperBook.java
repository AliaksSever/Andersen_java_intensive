package com.svrn.bookstore.books;

import java.util.Objects;

public class PaperBook extends Book{

    private Cover COVER_TYPE = Cover.Hardcover;
    private String publisher = "Unknown";

    public PaperBook(String title, String author, int pageNumber, double price) {
        super(title, author, pageNumber, price);
    }

    public PaperBook(String title, String author, int pageNumber, double price, Cover coverType) {
        this(title, author, pageNumber, price);
        COVER_TYPE = coverType;
    }

    public PaperBook(String title, String author, int pageNumber, double price, Cover coverType, String publisher) {
        this(title, author, pageNumber, price, coverType);
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Cover getCOVER_TYPE() {
        return COVER_TYPE;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", type: " + COVER_TYPE+
                ", publisher: " + publisher+
                "}.";
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            PaperBook paperBook = (PaperBook) o;
            return COVER_TYPE == paperBook.getCOVER_TYPE() &&
                    publisher.equals(paperBook.getPublisher());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), COVER_TYPE, publisher);
    }
}
