package cn.chart.manager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import com.example.mychart.DengLu;
import com.example.mychart.JieMian;
import com.example.mychart.MyApplication;
import com.example.mychart.ZhuCe;

import java.io.IOException;
import java.net.*;

/**
 * Created by 田益达 on 2016/8/20.
 */
public class sendrec {



//    Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            switch (msg.what){
//                case 11:
//                    new DengLu().goToJieMian(1);
////                    Intent it = new Intent(MyApplication.getContext(),JieMian.class);
////                    MyApplication.getContext().startActivity(it);
//                    break;
//                case 12:
//                    new DengLu().goToJieMian(2);
//
//                    break;
//                case 21:
//                    new ZhuCe().about(1);
//                    break;
//                case 22:
//                    new ZhuCe().about(2);
//                    break;
//
//            }
////            Bundle data = msg.getData();
////            String val = data.getString("value");
////            Log.i("mylog", "请求结果为-->" + val);
//            // TODO
//            // UI界面的更新等相关操作
//        }
//    };

    public void send(String data){
        /**
         * 网络操作相关的子线程
         */
        Runnable networkTask = new Runnable() {

            @Override
            public void run() {
                // TODO
                // 在这里进行 http request.网络请求相关操作
                DatagramSocket ds = null;
                try {
                    ds = new DatagramSocket();
                } catch (SocketException e) {
                    e.printStackTrace();
                }
                //2,将要发送的数据封装到数据包中。
//                String str = "udp comeing 000";
                //使用DatagramPacket将数据封装到的该对象包中。
                byte[] buf = data.getBytes();
                Log.i("...................","...."+data);

                DatagramPacket dp = null;
                try {
                    dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.191.1"), 9999);
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                //3，通过udp的socket服务将数据包发送出去。使用send方法。127.0.0.1/192.168.1.103
                try {
                    if (ds != null) {
                        Log.i(".....................", ".......have......");
                        ds.send(dp);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //4，关闭资源。
                if (ds != null) {
                    ds.close();
                }
//                rec();
            }
        };
        new Thread(networkTask).start();

    }
    public void rec(){
        /**
         * 网络操作相关的子线程
         */
        Runnable networkTask = new Runnable() {

            @Override
            public void run() {
                // TODO
                // 在这里进行 http request.网络请求相关操作

                DatagramSocket ds = null;
                try {
                    ds = new DatagramSocket(10005);
                } catch (SocketException e) {
                    e.printStackTrace();
                }
//                while (true) {
                    //2,创建数据包。
                    byte[] buf = new byte[1024];
                    DatagramPacket dp1 = new DatagramPacket(buf, buf.length);

                    //3,使用接收方法将数据存储到数据包中。
                try {
                        ds.receive(dp1);//阻塞式的。
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

//                4，通过数据包对象的方法，解析其中的数据,比如，地址，端口，数据内容。
                    String ip = dp1.getAddress().getHostAddress();
                    int port = dp1.getPort();
                    String text = new String(dp1.getData(), 0, dp1.getLength());
                    Log.i("..................",".......yes" + text);
                    String[] data = text.split("╬");

                if(data.length>1){
                    switch (data[0]){
                        case "zc":
                            if (data[1].equals("cz")) {
                                Toast.makeText(MyApplication.getContext(),"账号重复",Toast.LENGTH_LONG).show();
                                Message msg = new Message();
                                msg.what = 21;
                                ZhuCe.handler.sendMessage(msg);
                                Log.i("..................", ".......chongfu");
                            }
                            if (data[1].equals("cg")) {
                                Message msg = new Message();
                                msg.what = 22;
                                ZhuCe.handler.sendMessage(msg);
                                Log.i("..................", ".......nocf");
                            }
                            break;
                        case "dl":
                            if (data[1].equals("cg")) {
                                Message msg = new Message();
                                msg.what = 11;
                                DengLu.handler.sendMessage(msg);
                                Log.i("..................", ".......yes");
                            }
                            if(data[1].equals("cw")){
                                Message msg = new Message();
                                msg.what = 12;
                                DengLu.handler.sendMessage(msg);
                                Log.i("..................", ".......no");
                            }
                            break;
                        case "tj": break;
                        case "th": break;
                        case "sc": break;
                        case "tl": break;
                        case "sl": break;
                        case "lt": break;
                        case "sx": break;
                    }
                }


//                    switch (data.length){
//                        case 1:break;
//                        case 2:
//                                if(data[0].equals("dl1")) {
//                                    if (data[1].equals("true")) {
//                                        Message msg = new Message();
//                                        msg.what = 11;
//                                        DengLu.handler.sendMessage(msg);
//                                        Log.i("..................", ".......yes");
//                                    } else {
//                                        Message msg = new Message();
//                                        msg.what = 12;
//                                        DengLu.handler.sendMessage(msg);
//                                        Log.i("..................", ".......no");
//                                    }
//                                }
//                            if(data[0].equals("cf1")) {
//                                if (data[1].equals("true")) {
//                                    Message msg = new Message();
//                                    msg.what = 21;
//                                    ZhuCe.handler.sendMessage(msg);
//                                    Log.i("..................", ".......chongfu");
//                                } else {
//                                    Message msg = new Message();
//                                    msg.what = 22;
//                                    ZhuCe.handler.sendMessage(msg);
//                                    Log.i("..................", ".......nocf");
//                                }
//                            }
//                            break;
//                        case 3:
//
//                            break;
//                        case 4:break;
//                        case 5:break;
//                        case 6:break;
//                        case 7:break;
//                    }

//                    if (data.length == 2){
//                        if(data[0].equals("dl1") || data[0].equals("cf1")){
//                            ds.close();
//                        }
//
//                    }

                    Log.i("............" + text, "....................");
//                }
//                Message msg = new Message();
//                msg.what = 1;
//                DengLu.handler.sendMessage(msg);
            }
        };
        new Thread(networkTask).start();

    }
}
