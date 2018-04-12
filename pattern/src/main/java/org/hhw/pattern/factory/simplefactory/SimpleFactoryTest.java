package org.hhw.pattern.factory.simplefactory;

/**
 * Created by houhongwei on 2018/3/5.
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        CoffeeFactory coffeeFactory = new CoffeeFactory();
        StarbucksStore starbucksStore = new StarbucksStore(coffeeFactory);
        Coffee macchiato = starbucksStore.orderCoffee("Macchiato");
        macchiato.showName();
        Coffee mocha = starbucksStore.orderCoffee("Mocha");
        mocha.showName();
    }
}
