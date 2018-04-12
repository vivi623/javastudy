package org.hhw.pattern.factory.abstractfactory;

import org.hhw.pattern.factory.factory.PicMacchiato;
import org.hhw.pattern.factory.factory.PicMocha;
import org.hhw.pattern.factory.simplefactory.Coffee;

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
