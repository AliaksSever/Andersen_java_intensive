package com.svrn.bookstore.orders;

import com.svrn.bookstore.items.Item;
import com.svrn.bookstore.utils.Generable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.Instant;
import java.util.Objects;

public class Order<T extends Item> implements Generable{
    private static long IDCount = 1;
    private long ID;
    private final Map<Long, T> items = new HashMap<>();
    private final Instant openingTimeStamp;
    private Instant closingTimeStamp;
    private double totalPrice;
    private Status status;

    {
        openingTimeStamp = Instant.now();
        status = Status.OPENED;
        generateID();
    }

    public Order() {}

    public Order(T item) {
        addItem(item);
    }

    public Order(List<T> items) {
        for (T item: items) {
            addItem(item);
        }
    }

    public void addItem(T item) {
        totalPrice+=item.getPrice();
        items.put(item.getID(), item);
    }

    public long getID() {
        return ID;
    }

    public void generateID() {
        ID+=IDCount++;
    }

    public Map<Long, T> getItems() {
        return items;
    }

    public Instant getOpenTime() {
        return openingTimeStamp;
    }

    public Instant getCloseTime() {
        return closingTimeStamp;
    }
    public void setCloseTime() {
        closingTimeStamp = Instant.now();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{"+
                "ID: " + ID+
                ", Status: "+ status+
                ", totalPrice: "+totalPrice+
                ", opened: "+openingTimeStamp+
                ", closed: "+closingTimeStamp+
                ", items: " + items+
                "}.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass()!=o.getClass()) return false;
        Order<T> order = (Order<T>) o;
        return ID == order.getID() &&
                items.equals(order.getItems()) &&
                status == order.getStatus() &&
                openingTimeStamp == order.getOpenTime() &&
                totalPrice == order.getTotalPrice() &&
                closingTimeStamp == order.getCloseTime();
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, items, openingTimeStamp, closingTimeStamp, totalPrice, status);
    }
}
