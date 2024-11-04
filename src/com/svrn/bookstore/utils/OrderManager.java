package com.svrn.bookstore.utils;

import java.util.*;

import com.svrn.bookstore.items.Item;
import com.svrn.bookstore.orders.Order;
import com.svrn.bookstore.orders.Status;

public class OrderManager{

    private static final Map<Long, Order> ORDERS = new HashMap<>();

    public static final String OPEN_ORDER_MESSAGE = Status.OPENED.getMessage();
    public static final String CLOSE_ORDER_MESSAGE = Status.CLOSED.getMessage();
    public static final String COMPLETE_ORDER_MESSAGE = Status.COMPLETED.getMessage();

    public static final String OPENED_STATUS = Status.OPENED.getStatusDescription();
    public static final String CLOSED_STATUS = Status.CLOSED.getStatusDescription();
    public static final String COMPLETED_STATUS = Status.COMPLETED.getStatusDescription();

    private OrderManager() {}

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static Map<Long, Order> getOrders() {
        return ORDERS;
    }

    public static Order getOrder(long orderId){
        return ORDERS.get(orderId);
    }

    public static <T extends Item> void openOrder(List<T> items) {
        Order<T> newOrder = new Order<>(items);
        ORDERS.put(newOrder.getID(), newOrder);
        printMessage(OPEN_ORDER_MESSAGE + " with ID: " + newOrder.getID());
    }
    public static <T extends Item> boolean closeOrder(long orderId) {
        Order<T> order = ORDERS.get(orderId);
        if (order != null && order.getStatus().getStatusDescription().equals(OPENED_STATUS)) {
            order.setStatus(Status.CLOSED);
            printMessage(CLOSE_ORDER_MESSAGE);
            return true;
        }
        return false;
    }
    public static <T extends Item> boolean completeOrder(long orderId) {
        Order<T> order = ORDERS.get(orderId);
        if (order != null && order.getStatus().getStatusDescription().equals(OPENED_STATUS)) {
            order.setStatus(Status.COMPLETED);
            printMessage(COMPLETE_ORDER_MESSAGE);
            return true;
        }
        return false;
    }

    public static void showOrders() {
        List<Order> orders = new ArrayList<>(ORDERS.values());
        orders.sort(
                new OrderComparator().
                        thenComparing(Order::getTotalPrice).
                        thenComparing(Order::getOpenTime).
                        thenComparing(Order::getCloseTime).
                        thenComparing(Order::getStatus)
        );
        for (Order order: orders) {
            System.out.println(order);
        }
    }

    public static class OrderComparator implements Comparator<Order> {
        @Override
        public int compare(Order order1, Order order2) {
            return Long.compare(order1.getID(), order2.getID());
        }
    }


}
