package com.svrn.bookstore.services;

import com.svrn.bookstore.data.BookCatalog;
import com.svrn.bookstore.items.Book;
import com.svrn.bookstore.orders.Order;
import com.svrn.bookstore.utils.OrderManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BookStoreService {

    private static Map<Integer, Book> AVAILABLE_BOOKS = BookCatalog.BOOKS;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Available books are:");
        for (Map.Entry<Integer, Book> book: AVAILABLE_BOOKS.entrySet()) {
            Book availableBook = book.getValue();
            System.out.println(availableBook.getTitle() + " by " + availableBook.getAuthor() +", article: " + availableBook.getID());
        }
        System.out.println("\nWhould you like to create an order?(Y/n)");
        String answer1 = scan.next().toLowerCase();
        scan.nextLine();

        if (processOrder(answer1)) {
            System.out.println("\nPlease, chose books to add in you order using article, space between each");
            String answer2 = scan.nextLine();
            createOrder(answer2);
        } else {
            scan.close();
        }
    }

    private static boolean processOrder(String answer) {
        String yes = "y";
        String no = "n";

        if (answer.equals(yes)) {
            return true;
        } else if (answer.equals(no)) {
            return false;
        } else {
            System.out.println("Please, try again.");
            return false;
        }
    }

    private static void createOrder(String bookNumbers) {
        List<Book> books = new ArrayList<>();
        String[] bookNums = bookNumbers.split(" ");
        for (String bookNum: bookNums) {
            Book boodToAdd = AVAILABLE_BOOKS.get(Integer.parseInt(bookNum));
            if (boodToAdd!=null) {
                books.add(boodToAdd);
            }
        }
        if (books.size()>0) {
            Order order = OrderManager.openOrder(books);
            System.out.println("\nYour order:");
            order.showOrder();
        }
    }
}
