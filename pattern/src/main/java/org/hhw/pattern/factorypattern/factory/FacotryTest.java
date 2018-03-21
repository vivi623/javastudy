package org.hhw.pattern.factorypattern.factory;

/**
 * Created by houhongwei on 2018/3/6.
 */
public class FacotryTest {
    public static void main(String[] args) {
        Store store = new PacificStore();
        store.orderCoffee("Macchiato");
        store.orderCoffee("Mocha");

        Store starbucksStore = new StarbucksStore();
        starbucksStore.orderCoffee("Macchiato");
        starbucksStore.orderCoffee("Mocha");
    }
}
