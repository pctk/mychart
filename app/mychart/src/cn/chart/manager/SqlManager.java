package cn.chart.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 田益达 on 2016/9/6.
 */
public class SqlManager extends SQLiteOpenHelper{
    public static final String DB_NAME = "mychartsq.db";
    public static final int VERSION = 2;
    public SqlManager(Context context,String name) {

        super(context, name, null, VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        sqLiteDatabase = getWritableDatabase();
        String table_hy= "CREATE TABLE haoyou (" +
//                "zh  varchar(20) NULL ," +
                "id  varchar(20) NULL ," +
                "lbmz  varchar(20) NULL ," +
                "zt  int(1) NULL ," +
                "xxzt  int(1) NULL ," +
                "nc  varchar(255) NULL ," +
                "qm  varchar(255) NULL ," +
                "tx  varchar(255) NULL , " +
                "dj  varchar(255) NULL , " +
                "zw  text NULL , " +
                "PRIMARY KEY (id)" +
//                "CONSTRAINT wj FOREIGN KEY (lbmz) REFERENCES liebiao (lbmz)"+
                ");";
        String table_lb = "CREATE TABLE liebiao (" +
//                "zh  varchar(20) NULL ," +
                "lbmz  varchar(20) NULL " +
//                "PRIMARY KEY (lbmz)" +
                ");";
        String table_zl = "CREATE TABLE ziliao (" +
//                "zh  varchar(20) NULL ," +
                "nicheng  varchar(255) NULL ," +
                "qianming  varchar(255) NULL ," +
                "tx  varchar(255) NULL , " +
                "dj  varchar(255) NULL" +
                ");";
        sqLiteDatabase.execSQL(table_lb);
        sqLiteDatabase.execSQL(table_hy);
        sqLiteDatabase.execSQL(table_zl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
