package com.chart.service.send;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by 田益达 on 2016/8/20.
 */
public class SendDemo {
    private DatagramSocket ds = null;

    private void build(){
        System.out.println("发送端启动......");
		/*
		 * 创建UDP传输的发送端。
		 * 思路：
		 * 1，建立udp的socket服务。
		 * 2，将要发送的数据封装到数据包中。
		 * 3，通过udp的socket服务将数据包发送出去。
		 * 4，关闭socket服务。
		 */
        //1,udpsocket服务。使用DatagramSocket对象。

        try {
            ds = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }


//		String str = "udp传输演示：哥们来了！";
//        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
//        String line = null;
//
//        try {
//            while((line=bufr.readLine())!=null){
//
//
//                byte[] buf = line.getBytes();
//                DatagramPacket dp =
//                        new DatagramPacket(buf,buf.length, InetAddress.getByName("192.168.191.2"),10005);
//                ds.send(dp);
//
//                if("886".equals(line))
//                    break;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        //4，关闭资源。192.168.0.100/192.168.191.1
//        ds.close();
    }

    public void sendData(String ip,String data){
        build();
        //使用DatagramPacket将数据封装到的该对象包中。
        byte[] buf = data.getBytes();
        System.out.println("send......"+data);
        try {
            DatagramPacket dp =
                    new DatagramPacket(buf,buf.length, InetAddress.getByName(ip),10005);
            ds.send(dp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ds.close();
    }
}
