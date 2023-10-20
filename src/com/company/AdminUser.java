package com.company;

public class AdminUser {
    public static void main(String[] args) {
        System.out.println(ProxyClass.getWarehouseList().size());

        Item itemMango = new Item("mango", 20);
        Item itemApple = new Item("apple", 10);
        Item  itemOrange = new Item("orange", 30);
        WarHouse  wHouse = new WarHouse();
        wHouse.setEmail("chaity.paul193@gmail.com");
        wHouse.setAddress("Dhaka");
        wHouse.setPhone("01234567890");
        wHouse.addStock(itemMango.getName(), 50);
        wHouse.addStock(itemApple.getName(), 40);
        wHouse.addStock(itemOrange.getName(), 30);
        ProxyClass.addWarehouse(wHouse);
        WarHouse warHouse = new WarHouse();

        warHouse.addStock(itemMango.getName(), 10);
        warHouse.addStock(itemApple.getName(), 20);
        warHouse.addStock(itemOrange.getName(), 30);
        ProxyClass.addWarehouse(warHouse);
        System.out.println(ProxyClass.getWarehouseList().size());



    }
}
