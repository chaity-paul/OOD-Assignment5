package com.company;

import java.util.Hashtable;

public class WarHouse implements IOrder, Admin {
    private final Hashtable<String, Integer> stocks;
    private String address;
    private String phone;
    private String email;

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public WarHouse() {
        stocks = new Hashtable<>();
    }

    @Override
    public Hashtable<String, Integer> fullFillOrder(Order order) {
        Hashtable<String, Integer> sellItem = new Hashtable<>();
        for (ItemOrder itemOrder : order.getItems()) {
            int x = this.removeStock(itemOrder.getItem().getName(), itemOrder.getQuantity());
            sellItem.put(itemOrder.getItem().getName(), x);
        }
        return sellItem;
    }

    public void addStock(String itemName, int quantity) {
        if (stocks.containsKey(itemName)) {
            stocks.put(itemName, stocks.get(itemName) + quantity);
        } else {
            stocks.put(itemName, quantity);
        }

    }

    int currentInventory(String itemName) {
        if (!stocks.containsKey(itemName)) {
            return 0;
        }
        return stocks.get(itemName);
    }

    int removeStock(String itemName, int quantity) {
        if (!stocks.containsKey(itemName)) {
            return 0;
        }
        int current = stocks.get(itemName);
        if (current < quantity) {
            return 0;
        }
        stocks.put(itemName, current - quantity);
        return quantity;

    }
}
