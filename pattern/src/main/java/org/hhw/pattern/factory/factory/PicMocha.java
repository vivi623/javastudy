package org.hhw.pattern.factory.factory;

import org.hhw.pattern.factory.simplefactory.Coffee;

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
