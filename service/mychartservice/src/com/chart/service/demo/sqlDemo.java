package com.chart.service.demo;

import com.chart.service.chuli.LuoJiChuLi;
import com.chart.service.sql.SqlBuild;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

/**
 * Created by ����� on 2016/8/20.
 */
public class sqlDemo {

    private static Statement statement;
    private static Connection connection;

    public static void main(String args[]) {


//        String b[] = new String[1];
//        b[0] = "123";
//        System.out.println(b.hashCode());
//        shy(b);
//        System.out.println(b.hashCode());
//        if(new SqlBuild().dengLuPanDuan("123456","123456")){
//            System.out.print("have");
//        }else {
//            System.out.print("null");
//        }
//        new SqlBuild().updataip("123456","192.168.1.1");
//
//       new SqlBuild().insertData("112233","112233","192.168.191.2");


//        String str = "CREATE DATABASE `778899` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci; ";
////        String str = "SELECT * FROM user";
//        try {     //加载驱动程序 buileSql
//            Class.forName("com.mysql.jdbc.Driver");
//            //URL指向要访问的数据库名chart
//            String url = "jdbc:mysql://localhost:3306/mychart";
//            //MySQL配置时的用户名
//            String user = "root";
//            //MySQL配置时的密码
//            String password = "123456";
//            //连续数据库
//
//            connection = DriverManager.getConnection(url, user, password);
//            if (!connection.isClosed())
//                System.out.println("Succeeded  connecting  to  the  Database!");
//
//            //statement用来执行SQL语句
//            statement = connection.createStatement();
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            System.out.println(statement.execute(str));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//    static void shy(String[] a){
//        a[0] = "789";
//        System.out.println(a.hashCode());
//    }



//        new SqlBuild().insertDatabase("147685");
//        new SqlBuild().insertLbData("147685","wsaw");
//        new SqlBuild().insertHyData("147685","78946","wsaw","nc","qm","tx","dj");
//
//        new SqlBuild().insertZlData("147685","nc","qm","tx","dj");

//        new SqlBuild().updataData("112233","11111",0);
//        new SqlBuild().updataHyData("147685","78946","wsaw","sfsd","ds","fss","dfa");
//        new SqlBuild().updataLtData("147685","78946","456");
//        new SqlBuild().deleteHyData("147685","78946");
//        new SqlBuild().deleteLtData("147685","78946");

//        System.out.println(new SqlBuild().dengLuPanDuan("112233","112233"));
//        System.out.println(new SqlBuild().selectHyData("147685"));
//        System.out.println(new SqlBuild().selectLtData("147685","78946"));

//        System.out.println(new SqlBuild().selectLbData("147685"));
//        System.out.println(new SqlBuild().selectZlData("147685"));︾︽

//        String s = "sadf︾dsf︾gfdsf";
//        String[] data = s.split("︾");
//
//        System.out.print(data[0]+"...."+data[2]);


//        new LuoJiChuLi().zhuCe("12346","zc╬123456╬123456╬kl");
//        new LuoJiChuLi().dengLu("1254","dl╬1256╬123456");
//
//        new LuoJiChuLi().tianJia("12345","tj╬123456╬1256╬as");
//        new LuoJiChuLi().tianJiaPanDuan("12345","tp╬123456╬1256╬dd╬ty");
        System.out.println(".." + "︾".length());


    }
}
