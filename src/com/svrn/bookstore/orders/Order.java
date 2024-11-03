package com.svrn.bookstore.orders;

import com.svrn.bookstore.books.Book;

import java.time.Instant;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Order<T extends Book> {
    private static int ID_COUNTER = 1;

    private long ID;
    private final List<T> items = new LinkedList<>();
    private Status status;
    private final Instant openingTimeStamp;
    private ReceiveType receiveType = ReceiveType.SelfPickUp;
    private double discount;
    private double totalPrice;
    private Instant closingTimeStamp;

    public Order(T item) {
        items.add(item);
        this.status = Status.Opened;
        openingTimeStamp = Instant.now();
        CountTotalPrice();
        ID=ID_COUNTER++;
    }
    public Order(List<T> items) {
        this.items.addAll(items);
        this.status = Status.Opened;
        openingTimeStamp = Instant.now();
        CountTotalPrice();
        ID=ID_COUNTER++;
    }

    public Order(T item, ReceiveType receiveType) {
        items.add(item);
        this.status = Status.Opened;
        openingTimeStamp = Instant.now();
        this.receiveType = receiveType;
        CountTotalPrice();
        ID=ID_COUNTER++;
    }
    public Order(List<T> items, ReceiveType receiveType) {
        this.items.addAll(items);
        this.status = Status.Opened;
        openingTimeStamp = Instant.now();
        this.receiveType = receiveType;
        CountTotalPrice();
        ID=ID_COUNTER++;
    }

    public Order(T item, double discount) {
        items.add(item);
        this.status = Status.Opened;
        openingTimeStamp = Instant.now();
        this.discount = discount;
        CountTotalPrice();
        ID=ID_COUNTER++;
    }
    public Order(List<T> items, double discount) {
        this.items.addAll(items);
        this.status = Status.Opened;
        openingTimeStamp = Instant.now();
        this.discount = discount;
        CountTotalPrice();
        ID=ID_COUNTER++;
    }

    public Order(T item, ReceiveType receiveType, double discount) {
        items.add(item);
        this.status = Status.Opened;
        openingTimeStamp = Instant.now();
        this.receiveType = receiveType;
        this.discount = discount;
        CountTotalPrice();
        ID=ID_COUNTER++;
    }
    public Order(List<T> items, ReceiveType receiveType, double discount) {
        this.items.addAll(items);
        this.status = Status.Opened;
        openingTimeStamp = Instant.now();
        this.receiveType = receiveType;
        this.discount = discount;
        CountTotalPrice();
        ID=ID_COUNTER++;
    }

    public long getID() {
        return ID;
    }

    public List<T> getItems() {
        return items;
    }
    public void setItems(List<T> newItems) {
        items.clear();
        items.addAll(newItems);
    }
    public void addItem(T item) {
        items.add(item);
    }
    public void delItem(T item) {
        items.remove(item);
    }


    public Status getStatus() {
        return status;
    }
    public void setStatus(Status newStatus) {
        this.status = newStatus;
    }

    public Instant getOpeningTimeStamp() {
        return openingTimeStamp;
    }

    public Instant getClosingTimeStamp() {
        return closingTimeStamp;
    }
    public void setClosingTimeStamp() {
        this.closingTimeStamp = Instant.now();
    }

    public ReceiveType getReceiveType() {
        return receiveType;
    }
    public void setReceiveType(ReceiveType receiveType) {
        this.receiveType = receiveType;
    }

    public double getDiscount() {
        return discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void completeOrder() {
        status = Status.Completed;
        setClosingTimeStamp();
    }

    public void closeOrder() {
        status = Status.Closed;
        setClosingTimeStamp();
    }

    public void CountTotalPrice() {
        double itemsPrice = 0;
        for (T item: items) {
            itemsPrice+=item.getPrice();
        }
        totalPrice = itemsPrice - discount + receiveType.getShipmentPrice();
    };

    @Override
    public String toString() {
        return "Order{"+
                "items: " + items+
                ", Status: "+ status+
                ", ReceiveType: "+ receiveType+
                ", discount: "+ discount+
                ", totalPrice: "+totalPrice+
                "}.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass()!=o.getClass()) return false;
        Order<T> order = (Order<T>) o;
        Collections.sort(items);
        Collections.sort(order.getItems());

        return ID == order.getID() &&
                items.equals(order.getItems()) &&
                status == order.getStatus() &&
                openingTimeStamp == order.getOpeningTimeStamp() &&
                receiveType == order.getReceiveType() &&
                discount == order.getDiscount() &&
                totalPrice == order.getTotalPrice() &&
                closingTimeStamp == order.getClosingTimeStamp();
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, items, status, openingTimeStamp, receiveType, discount, totalPrice, closingTimeStamp);
    }
}
