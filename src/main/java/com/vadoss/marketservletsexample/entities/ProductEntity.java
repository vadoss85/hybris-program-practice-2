package com.vadoss.marketservletsexample.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class ProductEntity {
    int id;
    String name;
    int price;
    ProductStatuses status;
    LocalDateTime creationDate;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getName() {
        return name;
    }

    public ProductEntity(int id, String name, int price, String status, LocalDateTime creationDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = ProductStatuses.get(status);
        this.creationDate = creationDate;
    }
    public ProductEntity(int id, String name, int price, String status, String creationDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = ProductStatuses.get(status);
        this.creationDate = LocalDateTime.parse(creationDate, formatter);
    }

    public ProductStatuses getStatus() {
        return status;
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }
//    public ProductEntity(int id, String name, int price) {
//        this.id = id;
//        this.name = name;
//        this.price = price;
//    }
}

