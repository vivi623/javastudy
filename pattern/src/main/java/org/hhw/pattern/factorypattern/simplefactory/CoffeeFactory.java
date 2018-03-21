package org.hhw.pattern.factorypattern.simplefactory;

/**
 * Created by houhongwei on 2018/3/5.
 */
public class CoffeeFactory {
    public Coffee createCoffee(String type) {
        if("Macchiato".equals(type)) {
            return new Macchiato();
        } else if("Mocha".equals(type)) {
            return new Mocha();
        }
        return null;
    }
}
