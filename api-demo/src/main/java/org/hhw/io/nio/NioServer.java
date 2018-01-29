package org.hhw.io.nio;

import java.io.IOException;
import java.nio.channels.Selector;

public class NioServer {
    public static void main(String[] args) {
        try {
            Selector selector = Selector.open();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
