package com.company;

public class Item {
    private final String name;
    private final double price;
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public Item(String name) {
        this.name = name;
        this.price = 0;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
}
