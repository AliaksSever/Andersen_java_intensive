package com.svrn.bookstore.utils;

import com.svrn.bookstore.orders.Order;
import com.svrn.bookstore.orders.Status;
import com.svrn.bookstore.books.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderManager{

    private static final Map<Long, Order<Book>> ORDER_LIST = new HashMap<>();

    private static final String OPEN_ORDER_MESSAGE = "Order has been opened";
    private static final String CLOSE_ORDER_MESSAGE = "Order has been closed";
    private static final String COMPLETE_ORDER_MESSAGE = "Order has been completed";

    private OrderManager() {}

    public static Order<Book> createOrder(Book book) {
        Order<Book> order = new Order<>(book);
        printMessage(OPEN_ORDER_MESSAGE);
        return order;
    }
    public static Order<Book> createOrder(List<Book> bookList) {
        Order<Book> order = new Order<>(bookList);
        ORDER_LIST.put(order.getID(), order);
        printMessage(OPEN_ORDER_MESSAGE);
        return order;
    }

    public static Order<Book> closeOrder(Order<Book> order) {
        if (order.getStatus() == Status.Opened) {
            Order<Book> closedOrder = ORDER_LIST.get(order.getID());
            closedOrder.setStatus(Status.Closed);
            printMessage(CLOSE_ORDER_MESSAGE);
            return order;
        }
    }

    public static Order<Book> completeOrder(Order<Book> order) {
        if (order.getStatus() == Status.Opened) {
            Order<Book> completedOrder = ORDER_LIST.get(order.getID());
            completedOrder.setStatus(Status.Completed);
            printMessage(COMPLETE_ORDER_MESSAGE);
            return order;
        }
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static Map<Long, Order<Book>> getOrderList() {
        return ORDER_LIST;
    }

}
