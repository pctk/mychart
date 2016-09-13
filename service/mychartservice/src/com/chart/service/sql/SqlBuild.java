package com.chart.service.sql;

/**
 * Created by 田益达 on 2016/8/20.
 */
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

public class SqlBuild {
    private Statement statement;
    private Connection connection;

    public void SqlBuild(){

    }

    private void close(){

    }
    private void lianjieDatabase(String name) {
        try {     //加载驱动程序 buileSql

            Class.forName("com.mysql.jdbc.Driver");

            //URL指向要访问的数据库名chart
            String url = "jdbc:mysql://localhost:3306/"+name;
            //MySQL配置时的用户名
            String user = "root";
            //MySQL配置时的密码
            String password = "123456";
            //连续数据库

            connection = DriverManager.getConnection(url, user, password);
            if (!connection.isClosed())
                System.out.println("Succeeded  connecting  to  the  Database!");

            //statement用来执行SQL语句
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void buileSql(){
        try {     //加载驱动程序 buileSql
            Class.forName("com.mysql.jdbc.Driver");
            //URL指向要访问的数据库名chart
            String url = "jdbc:mysql://localhost:3306/mychart";
            //MySQL配置时的用户名
            String user = "root";
            //MySQL配置时的密码
            String password = "123456";
            //连续数据库

            connection = DriverManager.getConnection(url, user, password);
            if(!connection.isClosed())
                System.out.println("Succeeded  connecting  to  the  Database!");

            //statement用来执行SQL语句
            statement = connection.createStatement();


//            //要执行的SQL语句
//            String sql = "select * from user";
//            //执行SQL语句并返回结果集
//            ResultSet rs = statement.executeQuery(sql);
//            System.out.println("账号" + "\t" + "密码");
//            String num = null;
//
//            while(rs.next()) {
//                //选择password这列数据
//                num = rs.getString("password");
//                //输出结果
//                System.out.println(rs.getString("number") + "\t" + num);
//            }
//            //关闭结果集
//            rs.close();
//            //关闭连接
//            connection.close();
        }
        catch(ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

//    增
    public void insertDatabase(String name){
        String zh = name;

        name = 's'+name;

        lianjieDatabase("mysql");

        String str = "CREATE DATABASE "+name+" DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;";
        try {
            statement.execute(str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        lianjieDatabase(name);
        String table_hy= "CREATE TABLE haoyou (" +
                "id  varchar(20) NULL ," +
                "lbmz  varchar(20) NULL ," +
                "zt  int(1) NULL ," +
                "tjzt  int(1) NULL ," +
                "nc  varchar(255) NULL ," +
                "qm  varchar(255) NULL ," +
                "tx  varchar(255) NULL , " +
                "dj  varchar(255) NULL , " +
                "zw  text NULL , " +
                "PRIMARY KEY (id)" +
//                "CONSTRAINT wj FOREIGN KEY (lbmz) REFERENCES liebiao (lbmz)"+
                ");";
        String table_lb = "CREATE TABLE liebiao (" +
                "lbmz  varchar(20) NULL " +
//                "PRIMARY KEY (lbmz)" +
                ");";
        String table_zl = "CREATE TABLE ziliao (" +
                "nicheng  varchar(255) NULL ," +
                "qianming  varchar(255) NULL ," +
                "tx  varchar(255) NULL , " +
                "dj  varchar(255) NULL" +
                ");";
        try {
            statement.execute(table_zl);
            statement.execute(table_lb);
            statement.execute(table_hy);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        insertLbData(zh,"我的好友");
        insertZlData(zh,"用户"+zh,"签名","头像","等级");
    }
    public void insertHyData(String zh,String id,String lbmz,int zt){
        zh = 's' + zh;
        lianjieDatabase(zh);

        String sql = "insert haoyou values('"+id+"','"+ lbmz +"','',"+ zt +",'','','','','')";
        try {
            statement.execute(sql);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void insertLbData(String zh,String name){
        zh = 's' + zh;
        lianjieDatabase(zh);
        String sql = "insert liebiao values('"+ name +"')";
        try {
            statement.execute(sql);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void insertZlData(String zh,String nc,String qm,String tx,String dj){
        zh = 's' + zh;
        lianjieDatabase(zh);
        String sql = "insert ziliao values('"+nc+"','"+ qm +"','"+tx+"','"+dj+"')";
        try {
            statement.execute(sql);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertLsData(String id,String lsd){
        lianjieDatabase("mychart");

//        buileSql();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
//        java.util.Date date = new java.util.Date(System.currentTimeMillis());
//        String str = sdf.format(date);
        String sql = "insert lscc values('"+id+"','"+ lsd +"')";
        try {
            statement.execute(sql);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertData(String num,String pass,String ip,int zt){
        lianjieDatabase("mychart");

//        buileSql();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
//        java.util.Date date = new java.util.Date(System.currentTimeMillis());
//        String str = sdf.format(date);
        String sql = "insert user values('"+num+"','"+ pass +"','"+ip+"','"+zt+"')";
        try {
            statement.execute(sql);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    改
    public void updataHyData(String zh,String id){


        String bdData = selectZlData(id);
        zh = 's' + zh;
        lianjieDatabase(zh);
        String da[] = bdData.split("╬");

        String sql = "update haoyou " +
                "set tjzt=1 , nc='"+ da[0] +"',qm='"+ da[1] +"',tx='"+ da[2] +"',dj='"+ da[3] +"' " +
                "where id='" + id +"'";
        try {
            statement.execute(sql);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updataLtData(String zh,String id,String zw,int sr){
        zh = 's' + zh;
        lianjieDatabase(zh);
        if(sr == 1){
            zw = "︽" + zw + "&";
    }
        if(sr == 0){
            zw = "︾" + zw + "&";
        }
        String sql = "update haoyou " +
                "set zw= CONCAT(zw,'"+zw+"') " +
                "where id='" + id +"'";
        try {
            statement.execute(sql);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updataZlData(){}
    public void updataLbData(){}

    public void updataData(String num,String ip,int zt){
//        buileSql();
        lianjieDatabase("mychart");
        String sql = "update user set ip = '"+ip+"' where id = "+num;
        try {
            statement.execute(sql);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        updataZt(num,zt);
    }

    public void updataZt(String num,int zt){
        lianjieDatabase("mychart");
        String sql = "update user set zt = "+zt+" where id = "+num;
        try {
            statement.execute(sql);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    删
    public void deleteLsData(String id){
        lianjieDatabase("mychart");
        String sql = "delete FROM lscc WHERE id = ('"+ id +"')";
        try {
            statement.execute(sql);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteHyData(String zh,String id){
        zh = 's' + zh;
        lianjieDatabase(zh);
        String sql = "delete from haoyou " +
                "where id='" + id +"'";
        try {
            statement.execute(sql);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteLtData(String zh,String id){
        zh = 's' + zh;
        lianjieDatabase(zh);
        String sql = "update haoyou " +
                "set zw= '' " +
                "where id='" + id +"'";
        try {
            statement.execute(sql);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLbData(String zh,String name){
        zh = 's' + zh;
        lianjieDatabase(zh);
        String sql = "delete FROM liebiao WHERE lbmz = ('"+ name +"')";
        try {
            statement.execute(sql);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteZlData(){}
    public void deleteUsData(){}

//      查
    public String selectLsData(String id){
        lianjieDatabase("mychart");
        String ls = new String();
        try {
            //要执行的SQL语句
            String sql = "select * from lscc where id='" + id  + "'";
            //执行SQL语句并返回结果集
            ResultSet rs = null;
            try {
                rs = statement.executeQuery(sql);
                while (rs.next()) {
                    if (ls.equals("")) {
                        ls = rs.getString("nr");
                    } else {
                        ls = ls + "╬" + rs.getString("nr");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


                //关闭结果集
            rs.close();
            //关闭连接
            connection.close();
        } catch(SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return ls;
    }

    public int selectZaiXian(String id){
        lianjieDatabase("mychart");
        int zaiXian = 0;
        try {
            //要执行的SQL语句
            String sql = "select * from user where id='" + id  + "'";
            //执行SQL语句并返回结果集
            ResultSet rs = null;
            try {
                rs = statement.executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if(rs.next()){
//                System.out.print("have");
                zaiXian = rs.getInt("zt");
            }
            //关闭结果集
            rs.close();
            //关闭连接
            connection.close();
        } catch(SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return zaiXian;
    }

    public String selectCunZai(String id){
        lianjieDatabase("mychart");
        String cunZai = new String();
        try {
            //要执行的SQL语句
            String sql = "select * from user where id='" + id  + "'";
            //执行SQL语句并返回结果集
            ResultSet rs = null;
            try {
                rs = statement.executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if(rs.next()){
//                System.out.print("have");
                cunZai = "cz";
            }else{
                cunZai = "nz";
            }
            //关闭结果集
            rs.close();
            //关闭连接
            connection.close();
        } catch(SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return cunZai;
    }

    public String selectIpData(String zh){
        lianjieDatabase("mychart");
        String ip = new String();
        try {
            //要执行的SQL语句
            String sql = "select * from user where id='" + zh  + "'";
            //执行SQL语句并返回结果集
            ResultSet rs = null;
            try {
                rs = statement.executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if(rs.next()){
//                System.out.print("have");
                ip = rs.getString("ip");
            }
            //关闭结果集
            rs.close();
            //关闭连接
            connection.close();
        } catch(SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return ip;
    }
    public String selectZlData(String zh){
        zh = 's' + zh;
        lianjieDatabase(zh);
        String haou = " ";
        System.out.println(haou);
        String sql = "select * from ziliao";
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
            if (rs.last()){
                if(haou.equals(" ")){
                    haou = rs.getString("nicheng") +"∏"+ rs.getString("qianming")+"∏"+
                            rs.getString("tx")+"∏"+ rs.getString("dj");
                }
            }
            rs.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return haou;

    }
    public String selectLbData(String zh){
        zh = 's' + zh;
        lianjieDatabase(zh);
        String haou = new String();
        System.out.println(haou);
        String sql = "select * from liebiao";
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
//            rs.last();
            while (rs.next()){
                if(haou.equals("")){
                    haou = rs.getString("lbmz");
                }else {
                    haou = haou +"∏" + rs.getString("lbmz");
                }
            }
            rs.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return haou;
    }

    public String selectLtData(String zh,String id){
        zh = 's' + zh;
        lianjieDatabase(zh);
        String zw = new String();
        String sql = "select zw from haoyou where id="+id;
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
            while (rs.next()){
                zw = rs.getString("zw");
            }
            rs.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return zw;
    }

    public String selectHyData(String zh){
        zh = 's' + zh;
        lianjieDatabase(zh);
        String haou = " ";
        System.out.println(haou);
        String sql = "select * from haoyou WHERE tjzt = 1";
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
            while (rs.next()){
                if(haou.equals(" ")){
                    haou = rs.getString("id") +"#"+ rs.getString("lbmz")+"#"+
                            rs.getString("nc")+"#"+ rs.getString("qm")+"#"+
                            rs.getString("tx")+"#"+ rs.getString("dj")+"#"+
                            rs.getString("zw");
                }else {
                    haou = haou +"∏" + rs.getString("id") +"#"+ rs.getString("lbmz")+"#"+
                            rs.getString("nc")+"#"+ rs.getString("qm")+"#"+
                            rs.getString("tx")+"#"+ rs.getString("dj")+"#"+
                            rs.getString("zw");
                }

            }
            rs.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return haou;
    }
    public String chongfupanduan(String number){
//        buileSql();
        lianjieDatabase("mychart");
        int a = 0;
        try {
            //要执行的SQL语句
            String sql = "select * from user where id='" + number  + "'";
            //执行SQL语句并返回结果集
            ResultSet rs = null;
            try {
                rs = statement.executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if(rs.next()){
//                System.out.print("have");
                a = 1;
            }
            //关闭结果集
            rs.close();
            //关闭连接
            connection.close();
        } catch(SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return a == 1 ? "cz" : "cg";
    }
    public String dengLuPanDuan(String number,String password){
//        buileSql();
        lianjieDatabase("mychart");
        int a = 0;
     try {
            //要执行的SQL语句
        String sql = "select * from user where id='" + number + "'and passw='" + password + "'";
        //执行SQL语句并返回结果集
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

            if(rs.next()){
//                System.out.print("have");
                if(rs.getInt("zt") == 0)
                    a = 1;
                else
                    a = 2;
            }else {
//                System.out.print("null");
            }

        //关闭结果集
        rs.close();
        //关闭连接
        connection.close();
    } catch(SQLException e) {
        e.printStackTrace();
    } catch(Exception e) {
        e.printStackTrace();
    }

        return a == 1 ? "cg" : a == 2 ? "xx" : "cw";
    }

}
