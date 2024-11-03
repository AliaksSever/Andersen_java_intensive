package com.svrn.bookstore.orders;

public enum ReceiveType {

    Delivery(7.99),
    SelfPickUp(0);

    private double shipmentPrice;

    ReceiveType(double shipmentPrice) {
        this.shipmentPrice = shipmentPrice;
    }

    public double getShipmentPrice() {
        return shipmentPrice;
    }
    public void setShipmentPrice(double shipmentPrice) {
        this.shipmentPrice = shipmentPrice;
    }

}
