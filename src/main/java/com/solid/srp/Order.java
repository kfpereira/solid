package com.solid.srp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {

    private List<Item> items = new ArrayList<>();
    List<Order> orders = new ArrayList<>();

    public BigDecimal calculateTotalSum() {
        BigDecimal sum = BigDecimal.ZERO;
        for (Item item : Collections.unmodifiableList(items)) {
            sum = sum.add(item.getValor());
        }
        return sum;
    }

    public List<Item> getItems() {
        return items;
    }

    public Integer getItemCount() {
        return getItems().size();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void deleteItem(Item item) {
        int index = 0;
        for (Item currentItem : items) {
            if (currentItem.isSame(item)) {
                items.remove(index);
                return;
            }
            index++;
        }
    }

    public void printOrder(Order order) {
        for (Item item : order.getItems()) {
            System.out.println("*** " + item.getDescricao() + " - " + item.getValor());
        }
    }

    public List<Order> load() {
        return orders;
    }

    public void save(Order order) {
        orders.add(order);
    }

    public void update(Order oldOrder, Order newOrder) {
        if (orders.contains(oldOrder)) {
            int index = orders.indexOf(oldOrder);
            orders.remove(index);
            orders.add(index, newOrder);
        }
    }

    public void delete(Order order) {
        orders.remove(order);
    }


}
