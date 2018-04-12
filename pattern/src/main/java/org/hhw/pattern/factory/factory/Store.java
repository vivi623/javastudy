package org.hhw.pattern.factory.factory;

import org.hhw.pattern.factory.simplefactory.Coffee;

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
