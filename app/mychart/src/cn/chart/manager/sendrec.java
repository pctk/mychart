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
                Log.i("...................","..send.."+data);

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
}
