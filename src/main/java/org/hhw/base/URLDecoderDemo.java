package org.hhw.base;

import java.net.URLDecoder;

public class URLDecoderDemo {

    public static void main(String[] args) {
        String url = "(%20%20t2.sheetsource='net'%20and%20t1.orderstate='23')";
        String urlStr = URLDecoder.decode(url);
        System.out.println(urlStr);

        System.out.println(1%4);
    }
}
