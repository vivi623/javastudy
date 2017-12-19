package org.hhw.effective.singleton;

import java.io.*;

/**
 * 单例模式，序列化与序列化
 */
public class SingletonDemo2 implements Serializable {
    public static final SingletonDemo2 singleton = new SingletonDemo2();

    private SingletonDemo2() {
        //可以通过加强验证避免反射创建实例
        if(singleton != null) {
            throw new RuntimeException("instance error");
        }
    }

    /**
     * 加上此行，可保证反实例化的对象和原对象是一个
     * @return
     */
    private Object readResolve() {
        return singleton;
    }

    public static SingletonDemo2 getInstance() {
        return singleton;
    }

    public static void main(String[] args) {
        try {
            SingletonDemo2 singleton1 = SingletonDemo2.getInstance();
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("E://demo1.txt")));
            out.writeObject(singleton1);
            out.close();

            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File("E://demo1.txt")));
            SingletonDemo2 singleton2 = (SingletonDemo2)inputStream.readObject();
            inputStream.close();
            System.out.println(singleton1 == singleton2);

            ObjectInputStream inputStream2 = new ObjectInputStream(new FileInputStream(new File("E://demo1.txt")));
            SingletonDemo2 singleton3 = (SingletonDemo2)inputStream2.readObject();
            inputStream.close();

            System.out.println(singleton3 == singleton2);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
