package com.vadoss.marketservletsexample.entities;

public class OrderItemEntity {
    public int orderId;
    public int productId;
    public int quantity;

    public OrderItemEntity(int orderId, int productId, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
