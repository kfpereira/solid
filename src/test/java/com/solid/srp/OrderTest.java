package com.solid.srp;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

    private static final String ITEMS_QUANTITY = "Items Quantity";
    private static final String ORDERS_QUANTITY = "Orders Quantity";
    private Order order;

    @BeforeEach
    void setup() {
        order = loadOrderNumberOne();
    }

    @Test
    void shouldCalculateTotalSumAndItemsQuantity() {
        assertEquals(BigDecimal.valueOf(192.00), order.calculateTotalSum(), "Sum");
        assertEquals(9, order.getItemCount(), ITEMS_QUANTITY);
    }

    @Test
    void shouldRemoveAnItem() {
        order.deleteItem(getCoentro());
        assertEquals(BigDecimal.valueOf(188.80), order.calculateTotalSum(), "Sum");
        assertEquals(8, order.getItemCount(), ITEMS_QUANTITY);
    }

    @Test
    void shouldSaveAnOrder() {
        order.save(order);

        List<Order> orders = order.load();
        assertEquals(1, orders.size(), ORDERS_QUANTITY);
    }

    @Test
    void shouldSaveTwoOrders() {
        order.save(order);
        order.save(loadOrderNumberTwo());

        List<Order> orders = order.load();
        assertEquals(2, orders.size(), ORDERS_QUANTITY);
        assertEquals(9, orders.get(0).getItemCount(), ITEMS_QUANTITY);
        assertEquals(4, orders.get(1).getItemCount(), ITEMS_QUANTITY);
    }

    @Test
    void shouldUpdateAnOrder() {
        order.save(order);
        order.update(order, loadOrderNumberTwo());

        List<Order> orders = order.load();
        assertEquals(1, orders.size(), ORDERS_QUANTITY);

        Order result = orders.get(0);
        assertEquals(BigDecimal.valueOf(23.00), result.calculateTotalSum(), "Sum");
        assertEquals(4, result.getItemCount(), ITEMS_QUANTITY);
    }

    @Test
    void shouldRemoveAnOrder() {
        order.save(order);
        order.save(loadOrderNumberTwo());
        assertEquals(2, order.load().size(), ORDERS_QUANTITY);

        order.delete(order.load().get(1));
        assertEquals(1, order.load().size(), ORDERS_QUANTITY);
    }

    @Test
    void shouldPrintOrder() {
        order.save(loadOrderNumberTwo());
        assertEquals(1, order.load().size(), ORDERS_QUANTITY);
        order.printOrder(order.load().get(0));
    }

    private Order loadOrderNumberOne() {
        Order orderOne = new Order();
        orderOne.addItem(buildItem("cerveja", BigDecimal.valueOf(48.00)));
        orderOne.addItem(buildItem("vinho", BigDecimal.valueOf(49.90)));
        orderOne.addItem(buildItem("azeite", BigDecimal.valueOf(19.90)));
        orderOne.addItem(buildItem("carne moida", BigDecimal.valueOf(53.50)));
        orderOne.addItem(buildItem("macarrao", BigDecimal.valueOf(4.20)));
        orderOne.addItem(getCoentro());
        orderOne.addItem(buildItem("páprica", BigDecimal.valueOf(7.70)));
        orderOne.addItem(buildItem("cebola", BigDecimal.valueOf(2.00)));
        orderOne.addItem(buildItem("alho", BigDecimal.valueOf(3.60)));
        return orderOne;
    }

    private Item getCoentro() {
        return buildItem("coentro", BigDecimal.valueOf(3.20));
    }

    private Order loadOrderNumberTwo() {
        Order orderTwo = new Order();
        orderTwo.addItem(buildItem("banana", BigDecimal.valueOf(4.00)));
        orderTwo.addItem(buildItem("mamão", BigDecimal.valueOf(6.90)));
        orderTwo.addItem(buildItem("batata", BigDecimal.valueOf(7.10)));
        orderTwo.addItem(buildItem("tomate", BigDecimal.valueOf(5.00)));
        return orderTwo;
    }

    private Item buildItem(String cerveja, BigDecimal valor) {
        Item item = new Item();
        item.setDescricao(cerveja);
        item.setValor(valor);
        return item;
    }

}
