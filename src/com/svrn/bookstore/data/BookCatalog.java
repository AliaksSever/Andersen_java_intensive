package com.svrn.bookstore.data;

import com.svrn.bookstore.items.Book;
import java.util.Map;

public class BookCatalog {

    private BookCatalog() {}

    public static final Map<Integer, Book> BOOKS = Map.of(
            1, new Book("Crime and Punishment", "Fyodor Dostoevsky", 672, 23.5),
            2, new Book("The Master and Margarita", "Mikhail Bulgakov", 480, 19),
            3, new Book("Anna Karenina", "Leo Tolstoy", 864, 20.75),
            4, new Book("Short stories", "Anton Chekhov", 690, 17.99),
            5, new Book("The Old Man and the Sea", "Ernest Hemingway", 544, 18.99)
    );
}
