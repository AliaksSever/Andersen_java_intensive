package com.svrn.bookstore.books;

public class PaperBook extends Book{

    public final Cover COVER_TYPE;
    public String publisher;

    public PaperBook(String title, String author, int pageNumber, double price, Cover coverType) {
        super(title, author, pageNumber, price);
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

    @Override
    public String toString() {
        return super.toString() +
                ", type: " + COVER_TYPE+
                ", publisher: " + publisher+
                "}.";
    }
}
