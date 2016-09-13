package com.chart.service.rece;

import com.chart.service.chuli.LuoJiChuLi;
import com.chart.service.send.SendDemo;
import com.chart.service.sql.SqlBuild;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by ����� on 2016/8/20.
 */
public class ReceDemo {
    public static void main(String args[]){
        System.out.println("接收端启动......");
		/*
		 * 建立UDP接收端的思路。
		 * 1，建立udp socket服务,因为是要接收数据，必须要明确一个端口号。
		 * 2，创建数据包，用于存储接收到的数据。方便用数据包对象的方法解析这些数据.
		 * 3，使用socket服务的receive方法将接收的数据存储到数据包中。
		 * 4，通过数据包的方法解析数据包中的数据。
		 * 5，关闭资源
		 */

        //1,建立udp socket服务。
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(9999);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        while(true){

            //2,创建数据包。
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf,buf.length);

            //3,使用接收方法将数据存储到数据包中。
            try {
                ds.receive(dp);//阻塞式的。
            } catch (IOException e) {
                e.printStackTrace();
            }
//            dp.getAddress()

            //4，通过数据包对象的方法，解析其中的数据,比如，地址，端口，数据内容。
            String ip = dp.getAddress().getHostAddress();
            int port = dp.getPort();
            String text = new String(dp.getData(),0,dp.getLength());
            System.out.println(text);


            String[] data = text.split("╬");
//            System.out.println("yes..."+data[1]+"..."+data[2]+"..."+data.length);
//            for(String abc:data){
//
//            }
            if(data.length > 1) {
                switch (data[0]) {
                    case "zc":
                        new LuoJiChuLi().zhuCe(ip,text);
                        break;
                    case "dl":
                        new LuoJiChuLi().dengLu(ip,text);
                        break;
                    case "tj":
                        new LuoJiChuLi().tianJia(text);
                        break;
                    case "tp":
                        new LuoJiChuLi().tianJiaPanDuan(text);
                        break;
                    case "sc":
                        new LuoJiChuLi().shanChu(text);
                        break;
                    case "tl":
                        new LuoJiChuLi().tianJiaLieBiao(text);
                        break;
                    case "sl":
                        new LuoJiChuLi().shanChuLieBiao(text);
                        break;
                    case "lt":
                        new LuoJiChuLi().liaoTian(text);
                        break;
                    case "sx":
                        new LuoJiChuLi().shuaXin(text);
                        break;
                    case "xx":
                        new LuoJiChuLi().xiaXian(text);
                        break;
                }
            }

//            switch (data.length){
//                case 1:break;
//                case 2:
//                    if(data[0].equals("cf1")){
////                        if(new SqlBuild().chongfupanduan(data[1])){
////                            System.out.println("yes"+data[1]);
////                            new SendDemo().sendDenglu(2,1,ip);
////                        }else {
////                            System.out.println("no");
////                            new SendDemo().sendDenglu(2,2,ip);
////                        }
//                    }
//                    break;
//                case 3:
//                    if(data[0].equals("dl1")){
////                        if(new SqlBuild().dengLuPanDuan(data[1],data[2])){
////                            System.out.println("yes"+data[1]+"..."+data[2]);
//////                            new SqlBuild().updataip(data[1],ip);
////                            new SendDemo().sendDenglu(1,1,ip);
////                        }else {
////                            System.out.println("no");
////                            new SendDemo().sendDenglu(1,2,ip);
////                        }
//                    }
//                    if(data[0].equals("cf1")){
////                        new SqlBuild().insertData(data[1],data[2],ip);
////                        if(new SqlBuild().dengLuPanDuan(data[1],data[2])){
//                            System.out.println("yes"+data[1]+"...");
////                            new SqlBuild().updataip(data[1],ip);
////                            new SendDemo().sendDenglu(1,1,ip);
////                        }else {
////                            System.out.println("no");
////                            new SendDemo().sendDenglu(1,2,ip);
////                        }
//                    }
//                    break;
//                case 4:break;
//                case 5:break;
//                case 6:break;
//                case 7:break;
//            }

            System.out.println(ip+":"+port+":"+text);

        }
        //5,关闭资源。
//		ds.close();
    }

}
