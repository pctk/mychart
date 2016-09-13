package cn.chart.manager;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.example.mychart.AllChuLi;
import com.example.mychart.JieMian;
import com.example.mychart.MyApplication;

import java.util.ArrayList;

/**
 * Created by 田益达 on 2016/9/6.
 */
public class SqlAllChuLi extends HaoYou {
    private SQLiteDatabase db;


    public SqlAllChuLi(String zh) {
Log.i(".........Sql..","...zh.."+zh);
        SqlManager dbHelper = new SqlManager(MyApplication.getContext(),"cs"+zh+".db");
        // 在执行了getWritableDatabase的时候才会创建数据库,打开系统创建的数据库
        db = dbHelper.getWritableDatabase();
    }
//            增

    public void deleDatabase(String name){
        String str = "drop database " + name;
        db.execSQL(str);
    }

    public String hypd(String data){
        Cursor cursor = db.query("haoyou", null, "id =?", new String[]{data}, null, null, null);
        if (cursor.moveToNext()){
            Log.i("..............","hy");
            return "hy";
        }else{
            Log.i("..............","no");
            return "no";
        }

    }

    public void insertData(String data){

        String[] de = data.split("∏");

        for(String ls : de){
            if(!ls.equals(" ")) {

                String[] da = ls.split("#");
                if(hypd(da[0]).equals("hy")){

                    Log.i(".....tinajiahaoy...","hy..."+da[0]);
                    updataHyZlData("ss╬" + da[0] + "╬" + da[2] + "╬" + da[3] + "╬" + da[4] + "╬" + da[5]+ "╬" + da[6]);
                }
                if(hypd(da[0]).equals("no")){
                    Log.i(".....tinajiahaoy...","no..."+da[0]);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("id", da[0]);
                    contentValues.put("lbmz", da[1]);
                    contentValues.put("zt", 0);
                    contentValues.put("xxzt", 0);
                    contentValues.put("nc", da[2]);
                    contentValues.put("qm", da[3]);
                    contentValues.put("tx", da[4]);
                    contentValues.put("dj", da[5]);
                    contentValues.put("zw", da[6]);

                    db.insert("haoyou", null, contentValues);
                }

            }
        }




    }
    public String panduan(String data){
        Log.i("..............",data);
        Cursor cursor = db.query("liebiao", null, "lbmz =?", new String[]{data}, null, null, null);
        if (cursor.moveToNext()){
            Log.i("..............","hy");
            return "hy";
        }else{
            Log.i("..............","no");
            return "no";
        }

    }

    public void insertLbData(String data){

        String[] da = data.split("∏");
        for (String ls:da){
            if(panduan(ls).equals("no")) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("lbmz", ls);
                db.insert("liebiao", null, contentValues);
            }
        }

    }

    public void insertZlData(String data){
        if(!data.equals(" ")){
            String[] da = data.split("∏");
            ContentValues contentValues = new ContentValues();
            contentValues.put("nicheng",da[0]);
            contentValues.put("qianming",da[1]);
            contentValues.put("tx",da[2]);
            contentValues.put("dj",da[3]);
            db.insert("ziliao",null,contentValues);
        }

    }
//    删
    public void deleteLbData(String data){
        String[] da = data.split("╬");
        String stc = "DELETE FROM liebiao where lbmz='" + da[1]+"'";
        db.execSQL(stc);
    }
    public void deleteZlData(String id){

    }
    public void deleteHyData(String data){
        String[] da = data.split("╬");
        String stc = "DELETE FROM haoyou where id='" + da[1]+"'";
        db.execSQL(stc);
    }

//    改
    public void updataHyZlData(String data){
        String[] da = data.split("╬");

        ContentValues contentValues = new ContentValues();

        contentValues.put("nc",da[2]);
        contentValues.put("qm",da[3]);
        contentValues.put("tx",da[4]);
        contentValues.put("dj",da[5]);
        contentValues.put("zw",da[6]);

        db.update("haoyou", contentValues, "id=?", new String[]{String.valueOf(da[1])});
    }

    public void updataHySxData(String data){
        String[] da = data.split("╬");

        ContentValues contentValues = new ContentValues();
        contentValues.put("zt",da[2]);

        db.update("haoyou", contentValues, "id=?", new String[]{String.valueOf(da[1])});
    }
    public void updataHyLtData(String data,int xxzt){
        String[] da = data.split("╬");

        ContentValues contentValues = new ContentValues();
        contentValues.put("zw",da[1]);

        db.update("haoyou", contentValues, "id=?", new String[]{String.valueOf(da[0])});
    }
    public void updataHyXxData(String data,int xxzt){
//        String[] da = data.split("╬");

        ContentValues contentValues = new ContentValues();
//        contentValues.put("id",da[1]);
//        contentValues.put("lbmz",da[2]);
//        contentValues.put("zt",da[3]);
        contentValues.put("xxzt",xxzt);
//        contentValues.put("nc",da[4]);
//        contentValues.put("qm",da[5]);
//        contentValues.put("tx",da[6]);
//        contentValues.put("dj",da[7]);
//        contentValues.put("zw",da[8]);

        db.update("haoyou", contentValues, "id=?", new String[]{String.valueOf(data)});
    }

//    查

    public void selectXxZw(ArrayList<String> data,String id){
        Cursor cursor = db.query("haoyou", null, "id=?", new String[]{id}, null, null, null);
        int i = 1;
//        String[] da = new String[0];
        while (cursor.moveToNext()){

            Log.i("......sql...","....."+ i++);
            Log.i("......sql...","..546565156..."+ cursor.getString(8));
            String[] da = cursor.getString(8).split("&");
            Log.i("......sql...","..da..."+ da.length);
            for(String ls : da){
                data.add(ls);
                Log.i("......sql...","..da.da.."+ ls);
            }
        }

    }
    public void selectHyData(ArrayList<HaoYou> data){
        HaoYou ls = new HaoYou();
        Cursor cursor = db.query("haoyou", null, null, null, null, null, null);
        int i = 1;
        while (cursor.moveToNext()){

            Log.i("......sql...","....."+ i++);
            ls.setId(cursor.getString(0));
            Log.i("......sql...","..546565156..."+ cursor.getString(0));
            ls.setLbmz(cursor.getString(1));

            ls.setZt(cursor.getInt(2));
            ls.setXxzt(cursor.getInt(3));
            ls.setNc(cursor.getString(4));
            ls.setQm(cursor.getString(5));
            ls.setTx(cursor.getString(6));
            ls.setDj(cursor.getString(7));
            ls.setZw(cursor.getString(8));
            data.add(ls);
        }
    }
    public void selectLbData(ArrayList<String> data){

        Cursor cursor = db.query("liebiao", null, null, null, null, null, null);
        while (cursor.moveToNext()){
            data.add(cursor.getString(0));
        }
    }
    public void seltctZlData(ArrayList<ZiLiao> data){
        ZiLiao ls = new ZiLiao();
        Cursor cursor = db.query("ziliao", null, null, null, null, null, null);
        while (cursor.moveToNext()){
            ls.setNicheng(cursor.getString(0));
            ls.setQianming(cursor.getString(1));
            ls.setTx(cursor.getString(2));
            ls.setDj(cursor.getString(3));

            data.add(ls);
        }
    }


}
