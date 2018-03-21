package org.hhw.pattern.factorypattern.abstractfactory;

/**
 * Created by houhongwei on 2018/3/20.
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        AbstractFactory factory = new NYFactory();
        NYStore store = new NYStore(factory);
        store.orderCoffee("Macchiato");
    }
}
