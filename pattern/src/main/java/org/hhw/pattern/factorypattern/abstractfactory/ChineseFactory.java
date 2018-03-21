package org.hhw.pattern.factorypattern.abstractfactory;

/**
 * Created by houhongwei on 2018/3/20.
 */
public class ChineseFactory implements AbstractFactory {
    @Override
    public Milk createMilk() {
        return new MNMilk();
    }

    @Override
    public Chocolate createChocolate() {
        return new WhiteChocolate();
    }
}
