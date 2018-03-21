package org.hhw.pattern.factorypattern.abstractfactory;

/**
 * Created by houhongwei on 2018/3/20.
 */
public interface AbstractFactory {
    Milk createMilk();
    Chocolate createChocolate();
}
