package com.example.mychart;

import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import cn.chart.manager.SqlAllChuLi;

/**
 * Created by 田益达 on 2016/9/7.
 */
public class AllChuLi {
    public static String id;

    public static String zw;
//    public String getId(){
//        return this.id;
//    }

    public void zhuCe(String data){
        String[] da = data.split("╬");
        String send = "";
        Log.i("..........zhuce","run");
        if (da[1].equals("cz")) {
            Message msg = new Message();
            msg.what = 21;
            ZhuCe.handler.sendMessage(msg);
            Log.i("..................", ".......chongfu");
        }
        if (da[1].equals("cg")) {
            Message msg = new Message();
            msg.what = 22;
            ZhuCe.handler.sendMessage(msg);
            Log.i("..................", ".......nocf");
        }
    }

    public void dengLu(String data){
        String[] da = data.split("╬");
        String send = "";
        if (da[1].equals("cg")) {
            Message msg = new Message();
            msg.what = 11;
            DengLu.handler.sendMessage(msg);
            Log.i("..................", ".......yes");
        }
        if(da[1].equals("cw")){
            Message msg = new Message();
            msg.what = 12;
            DengLu.handler.sendMessage(msg);
            Log.i("..................", ".......no");
        }
        if(da[1].equals("xx")){
            Log.i("..................", ".......xx");
        }
    }

    public void tianJia(String data){
        String[] da = data.split("╬");
        String send = "";
        if(da[1].equals("nz")) {
            this.id = da[1];
            Message msg = new Message();
            msg.what = 1;
            JieMian.handler.sendMessage(msg);
        }else {
            Toast.makeText(MyApplication.getContext(),"不存在",Toast.LENGTH_LONG).show();
        }
    }
    public void tianJiaJieShou(String data){
        String[] da = data.split("╬");
        String send = "";
        if(da[2].equals("jj")){
            Toast.makeText(MyApplication.getContext(),da[1]+"拒绝",Toast.LENGTH_SHORT);
        }
        if(da[2].equals("ty")){
            Toast.makeText(MyApplication.getContext(),da[1]+"同意",Toast.LENGTH_SHORT);
        }
//        Message msg = new Message();
//        msg.what = 1;
//        JieMian.handler.sendMessage(msg);
    }

    public void shanChu(String data){
        String[] da = data.split("╬");
        String send = "";
        if(da[1].equals("cg")){
            Toast.makeText(MyApplication.getContext(),"成功",Toast.LENGTH_SHORT);
        }
    }

    public void tianJiaLieBiao(String data){
        String[] da = data.split("╬");
        if(da[1].equals("cg")){
            Toast.makeText(MyApplication.getContext(),"成功",Toast.LENGTH_SHORT);
        }
    }

    public void shanChuLieBiao(String data){
        String[] da = data.split("╬");
        if(da[1].equals("cg")){
            Toast.makeText(MyApplication.getContext(),"成功",Toast.LENGTH_SHORT);
        }
    }

    public void liaoTian(String data){
        String[] da = data.split("╬");
        this.id = da[1];
        if(da[1].equals(JieMian.ltid)){
            this.zw = da[2];
            Message msg = new Message();
            msg.what = 3;
            JieMian.handler.sendMessage(msg);
        }else {
            Message msg = new Message();
            msg.what = 4;
            JieMian.handler.sendMessage(msg);
            new SqlAllChuLi(JieMian.zh).updataHyLtData(da[1]+"╬"+da[2],1);
        }

    }

    public void shuaXin(String data){
        String[] da = data.split("╬");
        Log.i(".......Allchuli..zh....",da[4]);
        new SqlAllChuLi(da[4]).insertData(da[1]);
        new SqlAllChuLi(da[4]).insertLbData(da[3]);
        new SqlAllChuLi(da[4]).insertZlData(da[2]);
        Message msg = new Message();
        msg.what = 5;
        JieMian.handler.sendMessage(msg);
    }
}
