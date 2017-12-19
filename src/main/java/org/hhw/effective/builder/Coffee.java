package org.hhw.effective.builder;

/**
 * 构造器模式，应对可变参数
 * Created by houhongwei on 2017/12/19.
 */
public class Coffee {
    private String coffeeBean;
    private String water;
    private String suger;
    private String milk;
    private String fruit;
    private String cream;

    public static class Bulider {
        private String coffeeBean;
        private String water;
        private String suger;
        private String milk;
        private String fruit;
        private String cream;

        public Bulider(String coffeeBean, String water) {
            this.coffeeBean = coffeeBean;
            this.water = water;
        }

        public Bulider suger(String suger) {
            this.suger = suger;
            return this;
        }

        public Bulider milk(String milk) {
            this.milk = milk;
            return this;
        }

        public Bulider fruit(String milk) {
            this.fruit = fruit;
            return this;
        }

        public Bulider cream(String cream) {
            this.cream = cream;
            return this;
        }

        public Coffee build() {
            return new Coffee(this);
        }
    }

    private Coffee(Bulider build) {
        this.coffeeBean = build.coffeeBean;
        this.water = build.water;
        this.suger = build.suger;
        this.milk = build.milk;
        this.fruit = build.fruit;
        this.cream = build.cream;
    }

}
