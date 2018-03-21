package org.hhw.pattern.factorypattern.abstractfactory;

/**
 * Created by houhongwei on 2018/3/20.
 */
public class NYFactory implements AbstractFactory {
    @Override
    public Milk createMilk() {
        return new YLMilk();
    }

    @Override
    public Chocolate createChocolate() {
        return new BlackChocolate();
    }
}
