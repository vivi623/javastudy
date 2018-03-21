package org.hhw.pattern.factorypattern.abstractfactory;

/**
 * Created by houhongwei on 2018/3/20.
 */
public class MNMilk implements Milk {
    @Override
    public void showName() {
        System.out.println("this is 蒙牛 milk");
    }
}
