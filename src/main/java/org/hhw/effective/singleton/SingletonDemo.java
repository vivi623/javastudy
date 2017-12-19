package org.hhw.effective.singleton;

/**
 * 单例模式，注意java反射可以破坏单例
 */
public class SingletonDemo {
    public static final SingletonDemo singleton = new SingletonDemo();

    private SingletonDemo() {
        //可以通过加强验证避免反射创建实例
        if(singleton != null) {
            throw new RuntimeException("instance error");
        }
    }

    public static SingletonDemo getInstance() {
        return singleton;
    }

    public static void main(String[] args) {
        SingletonDemo demo1 = SingletonDemo.getInstance();
        SingletonDemo demo2 = SingletonDemo.singleton;

        System.out.println(demo1==demo2);

        // 可以通过动态创建实例，创建多个实例
        try {
            Class clz= Class.forName("org.hhw.effective.singleton.SingletonDemo");
            SingletonDemo demo3 = (SingletonDemo)clz.newInstance();
            System.out.println(demo1==demo3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


    }

}
