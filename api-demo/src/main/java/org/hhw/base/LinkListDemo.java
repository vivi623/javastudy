package org.hhw.base;

import java.util.concurrent.ConcurrentHashMap;

public class LinkListDemo {


    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        Node[] nodes = new Node[1];

        addNode(nodes, 0, 1, nodes[0]);
        addNode(nodes, 0, 2, nodes[0]);
        addNode(nodes, 0, 3, nodes[0]);
        addNode(nodes, 0, 4, nodes[0]);

//        for (Node next = nodes[0]; next != null; next = next.next) {
//            System.out.println(next.value);
//        }

        Node[] anodes = new Node[2];
        Node e = nodes[0];
        while(null != e) {
            Node next  = e.next;
//            System.out.println(next.value);
            e.next = anodes[1];
            anodes[1] = e;
            e = next;
        }

        for (Node anext = anodes[1]; anext != null; anext = anext.next) {
            System.out.println(anext.value);
        }

    }

    public static void  addNode(Node[] nodes,int index, int value, Node node) {
        Node old = nodes[index];
        nodes[index] = new Node(value, old);
        nodes[index].next = old;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}


