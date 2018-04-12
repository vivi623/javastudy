package org.hhw.pattern.factory.factory;

import org.hhw.pattern.factory.simplefactory.Coffee;
import org.hhw.pattern.factory.simplefactory.Macchiato;
import org.hhw.pattern.factory.simplefactory.Mocha;

/**
 * Created by houhongwei on 2018/3/6.
 */
public class StarbucksStore extends Store {

    @Override
    public Coffee createCoffee(String name) {
        if("Macchiato".equals(name)) {
            return new Macchiato();
        } else if("Mocha".equals(name)) {
            return new Mocha();
        }
        return null;
    }
}
