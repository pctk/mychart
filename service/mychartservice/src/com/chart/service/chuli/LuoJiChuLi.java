package com.chart.service.chuli;

//import android.util.Log;
import com.chart.service.send.SendDemo;
import com.chart.service.sql.SqlBuild;

/**
 * Created by 田益达 on 2016/9/5.
 */
public class LuoJiChuLi {

    public void zhuCe(String ip,String data){
        String[] da = data.split("╬");
        String send = "";
        if(new SqlBuild().chongfupanduan(da[1]).equals("cz")){
            send = "zc╬cz";
        }
        if(new SqlBuild().chongfupanduan(da[1]).equals("cg")){
            send = "zc╬cg";
            new SqlBuild().insertDatabase(da[1]);
            new SqlBuild().insertData(da[1],da[2],ip,0);
        }
        new SendDemo().sendData(ip,send);
        System.out.println(send);
    }

    public void sendLsDa(String id){

        String data = new SqlBuild().selectLsData(id);
        if(!data.equals("")) {
            String da[] = data.split("╬");
            for (String ls : da) {
                new SendDemo().sendData(new SqlBuild().selectIpData(id), ls);
            }
            if (da.length > 0)
                new SqlBuild().deleteLsData(id);
        }
    }

    public void dengLu(String ip,String data){
        String[] da = data.split("╬");
        String send = "";
        if(new SqlBuild().dengLuPanDuan(da[1],da[2]).equals("cg")){
            send = "dl╬cg╬"+da[1];
            new SqlBuild().updataData(da[1],ip,1);
            new SendDemo().sendData(ip,send);
            sendLsDa(da[1]);
        }
        if(new SqlBuild().dengLuPanDuan(da[1],da[2]).equals("xx")){
            send = "dl╬cg╬"+da[1];
            if(!ip.equals(new SqlBuild().selectIpData(da[1]))){
                new SendDemo().sendData(new SqlBuild().selectIpData(da[1]),"dl╬xx╬"+da[1]);

                System.out.println("xx");
            }


            new SqlBuild().updataData(da[1],ip,1);
            new SendDemo().sendData(ip,send);
            sendLsDa(da[1]);
        }
        if(new SqlBuild().dengLuPanDuan(da[1],da[2]).equals("cw")){
            send = "dl╬cw╬"+da[1];
            new SendDemo().sendData(ip,send);
        }
//        new SendDemo().sendData(new SqlBuild().selectIpData(da[1]),send);

        System.out.println(send);
    }

    public void tianJia(String data){
        String[] da = data.split("╬");
        String send = "";
        if(new SqlBuild().selectCunZai(da[2]).equals("cz")){

            System.out.println("cz");

            new SqlBuild().insertHyData(da[1],da[2],da[3],0);
            if(new SqlBuild().selectZaiXian(da[2]) == 1){
//                send = "";

                new SendDemo().sendData(new SqlBuild().selectIpData(da[2]),"tj╬"+da[1]);


                System.out.println("zx");
                System.out.println("tj╬"+da[1]);
            }
            if(new SqlBuild().selectZaiXian(da[2]) == 0){
//                存储

                new SqlBuild().insertLsData(da[2], "tj╬" + da[1]);


                System.out.println("nzx");
                System.out.println("tj╬"+da[1]);
            }
        }
        if(new SqlBuild().selectCunZai(da[2]).equals("nz")){

            System.out.println("nz");


            send = "tj╬nz";
            new SendDemo().sendData(new SqlBuild().selectIpData(da[1]),send);
        }


    }
    public void tianJiaPanDuan(String data){
        String[] da = data.split("╬");
        String send = "";
        if(da[4].equals("jj")){
            send = "th╬"+da[2]+"jj";
            new SqlBuild().deleteHyData(da[1],da[2]);


            System.out.println("jj");
        }
        if(da[4].equals("ty")){
            send = "th╬"+da[2]+"ty";


            System.out.println("ty");


            new SqlBuild().insertHyData(da[2],da[1],da[3],0);
            new SqlBuild().updataHyData(da[1],da[2]);
            new SqlBuild().updataHyData(da[2],da[1]);
        }

        if(new SqlBuild().selectZaiXian(da[1]) == 1){

            System.out.println("zx");

//                send = "";
            new SendDemo().sendData(new SqlBuild().selectIpData(da[1]),send);
        }
        if(new SqlBuild().selectZaiXian(da[1]) == 0){
//                存储
            new SqlBuild().insertLsData(da[1],send);

            System.out.println("cc");
        }

//        new SendDemo().sendData(ip,send);
    }

    public void shanChu(String data){
        String[] da = data.split("╬");
        String send = "";
        new SqlBuild().deleteHyData(da[1],da[2]);
        new SqlBuild().deleteHyData(da[2],da[1]);
        send = "sc╬cg";
        new SendDemo().sendData(new SqlBuild().selectIpData(da[1]),send);
    }

    public void tianJiaLieBiao(String data){
        String[] da = data.split("╬");

        new SqlBuild().insertLbData(da[1],da[2]);

        new SendDemo().sendData(new SqlBuild().selectIpData(da[1]),"tl╬cg");
    }

    public void shanChuLieBiao(String data){
        String[] da = data.split("╬");
//        String send = "";
        new SqlBuild().deleteLbData(da[1],da[2]);

        new SendDemo().sendData(new SqlBuild().selectIpData(da[1]),"sl╬cg");
//        new SendDemo().sendData(ip,send);
    }

    public void liaoTian(String data){
        String[] da = data.split("╬");
        String send = "";

        send = "lt╬"+da[1]+"╬"+da[3];
        new SqlBuild().updataLtData(da[1],da[2],da[3],1);
        da[3].replaceAll("︽","︾");

        new SqlBuild().updataLtData(da[2],da[1],da[3],0);

        if(new SqlBuild().selectZaiXian(da[2]) == 1){
            new SendDemo().sendData(new SqlBuild().selectIpData(da[2]),send);
        }
        else {
//            存储
            new SqlBuild().insertLsData(da[2],send);
        }

//        new SendDemo().sendData(ip,send);
    }

    public void shuaXin(String data){
        String[] da = data.split("╬");
        String send = "";
        send = "sx╬" + new SqlBuild().selectHyData(da[1])+"╬"+new SqlBuild().selectZlData(da[1])+"╬"+new SqlBuild().selectLbData(da[1])+"╬"+da[1];
        if(new SqlBuild().selectZaiXian(da[1]) == 1){
            new SendDemo().sendData(new SqlBuild().selectIpData(da[1]),send);
        }else{
//            存储
            new SqlBuild().insertLsData(da[1],send);
        }
        System.out.println(send);
    }

    public void xiaXian(String text) {
        String[] da = text.split("╬");
        new SqlBuild().updataZt(da[1],0);
    }
}
