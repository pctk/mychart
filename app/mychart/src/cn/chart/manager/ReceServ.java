//package cn.chart.manager;
//
//import android.os.Message;
//import android.util.Log;
//import com.example.mychart.AllChuLi;
//import com.example.mychart.DengLu;
//import com.example.mychart.ZhuCe;
//
//import java.io.IOException;
//import java.net.DatagramPacket;
//import java.net.DatagramSocket;
//import java.net.InetAddress;
//import java.net.SocketException;
//
///**
// * Created by 田益达 on 2016/9/6.
// */
//public class ReceServ {
//    public void rec(){
//        /**
//         * 网络操作相关的子线程
//         */
//        Runnable networkTask = new Runnable() {
//
//            @Override
//            public void run() {
//                // TODO
//                // 在这里进行 http request.网络请求相关操作
//                Log.i("...............","run");
//
//                DatagramSocket ds = null;
//                try {
//                    ds = new DatagramSocket(10005);
//                } catch (SocketException e) {
//                    e.printStackTrace();
//                }
////                while (true) {
//                    //2,创建数据包。
//                    byte[] buf = new byte[1024];
//                    DatagramPacket dp1 = new DatagramPacket(buf, buf.length);
//
//                    //3,使用接收方法将数据存储到数据包中。
//
//                    try {
//                        ds.receive(dp1);//阻塞式的。
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
////                4，通过数据包对象的方法，解析其中的数据,比如，地址，端口，数据内容。
//                    String ip = dp1.getAddress().getHostAddress();
//                    int port = dp1.getPort();
//                    String text = new String(dp1.getData(), 0, dp1.getLength());
//                    Log.i("..................", ".......yes..." + text);
//                    String[] data = text.split("╬");
//                    Log.i("..................", ".......data.length..." + data.length);
//                    Log.i("..................", ".......data[0]..." + data[0]);
//                    if (data.length > 1) {
//                        switch (data[0]) {
//                            case "zc":
//                                new AllChuLi().zhuCe(text);
//                                break;
//                            case "dl":
//                                new AllChuLi().dengLu(text);
//                                break;
//                            case "tj":
//                                new AllChuLi().tianJia(text);
//                                break;
//                            case "th":
//                                new AllChuLi().tianJiaJieShou(text);
//                                break;
//                            case "sc":
//                                new AllChuLi().shanChu(text);
//                                break;
//                            case "tl":
//                                new AllChuLi().tianJiaLieBiao(text);
//                                break;
//                            case "sl":
//                                new AllChuLi().shanChuLieBiao(text);
//                                break;
//                            case "lt":
//                                new AllChuLi().liaoTian(text);
//                                break;
//                            case "sx":
//                                new AllChuLi().shuaXin(text);
//                                break;
//                        }
//                    }
//                    ds.close();
//                }
////            }
//        };
//        new Thread(networkTask).start();
//
//    }
//
//
//}
