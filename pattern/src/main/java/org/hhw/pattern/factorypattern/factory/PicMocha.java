package org.hhw.pattern.factorypattern.factory;

import org.hhw.pattern.factorypattern.simplefactory.Coffee;

/**
 * 摩卡
 * Created by houhongwei on 2018/3/5.
 */
public class PicMocha extends Coffee {
    @Override
    public void showName() {
        System.out.println("this is PicMocha");
    }
}
