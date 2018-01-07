package org.hhw.effective.clone;

/**
 * Created by houhongwei on 2017/12/26.
 */
public class Clonedemo implements Cloneable {

    private String name;
    private Integer age;
    private Object[] elements;
    private int capacity = 16;
    private int size = 0;

    Clonedemo(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.elements = new Object[capacity];
    }

    public void push(Object obj) {
        if(size < 16) {
            elements[size++] = obj;
        }
    }

    public void changeElement(int index, Object e){
        elements[index] = e;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public Clonedemo clone() {
        Clonedemo demo = null;
        try {
            demo = (Clonedemo) super.clone();
            demo.elements = elements.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return demo;
    }

    @Override
    public String toString() {
        String str = "";
        for(int i = 0; i < size; i++) {
            str += elements[i] + ",";
        }
        return "name:" + name + ", age:" + age + ", elements:" + str;
    }

    public static void main(String[] args) {
        Clonedemo clonedemo = new Clonedemo("vivi", 18);
        clonedemo.push(1);
        clonedemo.push(2);
        clonedemo.push(3);

        Clonedemo demo =  clonedemo.clone();
        clonedemo.changeElement(2, 8);
        clonedemo.push(4);

        System.out.println(clonedemo);
        System.out.println(demo);


    }

}
