package com.company;

import java.util.Hashtable;

public interface IOrder {
    public Hashtable<String, Integer> fullFillOrder(Order order);
}
