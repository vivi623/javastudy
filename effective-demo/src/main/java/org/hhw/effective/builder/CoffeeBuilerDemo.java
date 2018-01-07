package org.hhw.effective.builder;

/**
 * Created by houhongwei on 2017/12/19.
 */
public class CoffeeBuilerDemo {
    public static void main(String[] args) {
        Coffee coffee = new Coffee.Bulider("咖啡豆", "水").milk("牛奶")
                .cream("奶油").suger("糖").build();

    }
}
