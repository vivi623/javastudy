package org.hhw.pattern.factory.simplefactory;

/**
 * Created by houhongwei on 2018/3/5.
 */
public class StarbucksStore {
    private CoffeeFactory coffeeFactory;

    public StarbucksStore(CoffeeFactory coffeeFactory) {
        this.coffeeFactory = coffeeFactory;
    }

    public Coffee orderCoffee(String name) {
        return coffeeFactory.createCoffee(name);
    }

}
