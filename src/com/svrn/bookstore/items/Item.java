package com.svrn.bookstore.items;

import com.svrn.bookstore.utils.Generable;

public abstract class Item implements Generable{
    private static long IDCount = 1;
    private long ID;
    private double price;

    public Item(double price) {
        generateID();
        this.price = price;
    }

    public long getID() {
        return ID;
    }

    public double getPrice() {
        return price;
    }

    public void generateID() {
        ID+=IDCount++;
    }
}
