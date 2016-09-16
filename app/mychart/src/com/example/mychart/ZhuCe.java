package com.example.mychart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//import cn.chart.manager.ReceServ;
import cn.chart.manager.sendrec;

/**
 * Created by ����� on 2016/8/21.
 */
public class ZhuCe extends Activity{
    public static Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhuce);
//        new ReceServ().rec();

        Button zhuce1 = (Button) findViewById(R.id.zhueceanniu);
        EditText edinum = (EditText) findViewById(R.id.zhuecenum);
        EditText edipass1 = (EditText) findViewById(R.id.zhuecepass1);
        EditText edipass2 = (EditText) findViewById(R.id.zhuecepass2);

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case 21:
                        Toast.makeText(ZhuCe.this,"账号重复",Toast.LENGTH_LONG).show();
                        break;
                    case 22:
//                        if(!edipass1.getText().toString().equals(edipass2.getText().toString())){
//                            Toast.makeText(ZhuCe.this,"两次密码不相同",Toast.LENGTH_LONG).show();
//                        }else {
//                            String data = "cf1:"+edinum.getText().toString()+":"+edipass2.getText().toString();
//                            new sendrec().send(data);
//                            Toast.makeText(ZhuCe.this,"成功",Toast.LENGTH_LONG).show();
//                        }
                        Toast.makeText(ZhuCe.this,"成功",Toast.LENGTH_LONG).show();
                        break;

                }
//            Bundle data = msg.getData();
//            String val = data.getString("value");
//            Log.i("mylog", "请求结果为-->" + val);
                // TODO
                // UI界面的更新等相关操作
            }
        };

        zhuce1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = "zc╬"+edinum.getText().toString()+"╬"+edipass2.getText().toString()+"╬nc";
                new sendrec().send(data);


            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent stop = new Intent(ZhuCe.this,MyService.class);
        stopService(stop);
    }
}
