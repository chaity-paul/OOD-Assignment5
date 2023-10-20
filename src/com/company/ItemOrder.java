package com.company;

public class ItemOrder {
    private final Item item;
    private int quantity;
    public ItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
    public Item getItem() {
        return item;
    }
    public int getQuantity() {
        return quantity;
    }
    public int setQuantity(int quantity) {
        return this.quantity = quantity;
    }
}
