package org.hhw.io.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServer {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(9999);
            System.out.println("启动服务器....");
            while (true) {
                Socket s = ss.accept();
                System.out.println("服务器:" + s.getInetAddress().getLocalHost() + "已连接到服务器");

                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                //读取客户端发送来的消息
                String mess = br.readLine();
                System.out.println("服务器：客户端发送的消息为是，" + mess);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                bw.write(mess + "\n");
                bw.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




