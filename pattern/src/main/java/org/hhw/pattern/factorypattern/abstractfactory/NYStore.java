package org.hhw.pattern.factorypattern.abstractfactory;

import org.hhw.pattern.factorypattern.factory.PicMacchiato;
import org.hhw.pattern.factorypattern.factory.PicMocha;
import org.hhw.pattern.factorypattern.simplefactory.Coffee;

/**
 * Created by houhongwei on 2018/3/20.
 */
public class NYStore {
    private AbstractFactory factory;
    private Milk milk;
    private Chocolate chocolate;

    public NYStore(AbstractFactory factory) {
        this.factory = factory;
    }

    void preCook(){
        chocolate = factory.createChocolate();
        chocolate.showName();
        milk = factory.createMilk();
        milk.showName();
    }

    public Coffee orderCoffee(String name) {
        preCook();
        Coffee coffee = createCoffee(name);
        coffee.showName();
        return coffee;
    }

    public Coffee createCoffee(String name) {
        if("Macchiato".equals(name)) {
            return new PicMacchiato();
        } else if("Mocha".equals(name)) {
            return new PicMocha();
        }
        return null;
    }
}
