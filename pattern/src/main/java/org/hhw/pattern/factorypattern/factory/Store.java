package org.hhw.pattern.factorypattern.factory;

import org.hhw.pattern.factorypattern.simplefactory.Coffee;

/**
 * Created by houhongwei on 2018/3/6.
 */
public abstract class Store {

    public Coffee orderCoffee(String name) {
        Coffee coffee = createCoffee(name);
        coffee.showName();
        return coffee;
    }

    protected abstract Coffee createCoffee(String name);
}
