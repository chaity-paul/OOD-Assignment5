package com.company;

public class CustomerUser {
    public static void main(String[] args) {
        AdminUser.main(args);
        IOrder  market = new ProxyClass();
        Order order = new Order();
        order.addItem(new Item("apple"), 4);
        order.addItem(new Item("orange"), 3);
        var result = market.fullFillOrder(order);
        System.out.println("These following items were sold");
        for(String key : result.keySet()){
            System.out.println(key + " " + result.get(key));
        }
        System.out.println(ProxyClass.getWarehouseList().size());
    }
}
