package com.vadoss.marketservletsexample.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderEntity {
    public int id;
    public int total;
    public int quantity;
    public String name;
    LocalDateTime creationDate;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public int getQuantity() {
        return quantity;
    }

    public OrderEntity(int id, int total, String name, int quantity, String creationDate) {
        this.id = id;
        this.total = total;
        this.name = name;
        this.quantity = quantity;
        this.creationDate = LocalDateTime.parse(creationDate, formatter);
    }

    public int getId() {
        return id;
    }

    public int getTotal() {
        return total;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}
