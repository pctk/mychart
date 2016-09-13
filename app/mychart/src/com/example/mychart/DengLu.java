package com.example.mychart;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import cn.chart.manager.ReceServ;
import cn.chart.manager.SqlAllChuLi;
import cn.chart.manager.sendrec;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by ����� on 2016/8/20.
 */
public class DengLu extends Activity{
    public static Handler handler;
    String numb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.denglu);

//        new SqlAllChuLi("mychart").deleDatabase("cs123");
//        new SqlAllChuLi("mychart").deleDatabase("c123");
//        new SqlAllChuLi("mychart").deleDatabase("cs123456");
//        new SqlAllChuLi("mychart").deleDatabase("csnull");
//        new SqlAllChuLi("mychart").deleDatabase("mycharts");
//        new SqlAllChuLi("mychart").deleDatabase("mychartsq");

//

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                new ReceServ().rec();
//            }
//        }).start();

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case 11:
                    Intent it = new Intent(DengLu.this,JieMian.class);
                        it.putExtra("zh",numb);
                        startActivity(it);
                        break;
                    case 12:
                        Toast.makeText(DengLu.this,"登录失败，原因自找",Toast.LENGTH_LONG).show();
                        break;
                    case 21:
//                        new ZhuCe().about(1);
                        break;
                    case 22:
//                        new ZhuCe().about(2);
                        break;

                }
//            Bundle data = msg.getData();
//            String val = data.getString("value");
//            Log.i("mylog", "请求结果为-->" + val);
                // TODO
                // UI界面的更新等相关操作
            }
        };
        EditText num = (EditText) findViewById(R.id.editnum);
        EditText password = (EditText) findViewById(R.id.editpassword);

        Button denglu = (Button) findViewById(R.id.denglu);

        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numb = num.getText().toString();
                String pass = password.getText().toString();
                String data = "dl╬"+numb+"╬"+pass;
                new sendrec().send(data);
                new ReceServ().rec();
            }
        });

        Button zhuce = (Button) findViewById(R.id.zhuce);
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(DengLu.this,ZhuCe.class);
                startActivity(it);
            }
        });
    }
}
