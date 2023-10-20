package com.company;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ProxyClass implements IOrder{
    private static final List<WarHouse> warehouseList = new ArrayList<>();
    public ProxyClass(){

    }
    public static void addWarehouse(WarHouse warHouse){
        warehouseList.add(warHouse);
    }
    public static List<WarHouse> getWarehouseList(){
        return warehouseList;
    }
    @Override
    public Hashtable<String, Integer> fullFillOrder(Order order) {
        Hashtable<String, Integer> sellItem = new Hashtable<>();
        for (ItemOrder itemOrder : order.getItems()) {
            for(WarHouse  warHouse : warehouseList){
                int currentStock = warHouse.currentInventory(itemOrder.getItem().getName());
                if(currentStock >= itemOrder.getQuantity()){
                    if(sellItem.containsKey(itemOrder.getItem().getName())){
                        sellItem.put(itemOrder.getItem().getName(), sellItem.get(itemOrder.getItem().getName()) + itemOrder.getQuantity());
                        warHouse.removeStock(itemOrder.getItem().getName(), itemOrder.getQuantity());
                    }else{
                        sellItem.put(itemOrder.getItem().getName(), itemOrder.getQuantity());
                        warHouse.removeStock(itemOrder.getItem().getName(), itemOrder.getQuantity());
                    }
                    itemOrder.setQuantity(0);
                    break;
                }else{
                    itemOrder.setQuantity(itemOrder.getQuantity() -currentStock);
                    if(sellItem.containsKey(itemOrder.getItem().getName())){
                        sellItem.put(itemOrder.getItem().getName(), sellItem.get(itemOrder.getItem().getName()) + currentStock);
                    }else{
                        sellItem.put(itemOrder.getItem().getName(), currentStock);
                    }
                    warHouse.removeStock(itemOrder.getItem().getName(), currentStock);

                }
            }
        }
        return sellItem;
    }
}
