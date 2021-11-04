package com.vadoss.marketservletsexample.entities;

public class OrderedProductEntity {
    int productId;
    String name;
    int quantity;

    public OrderedProductEntity(int productId, String name, int quantity) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
