package org.hhw.base;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Iptest {
    public static void main(String[] args) {
        try {
            /**
             * 获取本机的IP地址
             * 如果host中配置了ip 返回配置的结果
             * 如我本机的ip为10.0.24.82 但是我配置了host 10.0.24.83 HOUHONGWEI-PC，则该方法返回10.0.24.83
             */
            String ip = InetAddress.getLocalHost().getHostAddress();
            String hostname = InetAddress.getLocalHost().getHostName();
            System.out.println(ip);
            System.out.println(hostname);
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        }
    }
}
