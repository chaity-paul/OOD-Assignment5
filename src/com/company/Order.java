package com.company;

import java.util.ArrayList;
import java.util.List;
public class Order {
    private final List<ItemOrder> items;
    public Order(){
        items = new ArrayList<>();

    }
    public void addItem(Item item, int quantity){
        if(quantity <=0) {
            System.out.println("invalid quantity");
        }else {
            System.out.println("Item Successfully added.");
            items.add(new ItemOrder(item, quantity));
        }
    }
    public List<ItemOrder> getItems() {
        return items;
    }


}
