package com.example.mychart;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import cn.chart.manager.HaoYou;
import cn.chart.manager.ReceServ;
import cn.chart.manager.SqlAllChuLi;
import cn.chart.manager.sendrec;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Created by 田益达 on 2016/8/21.
 */
public class JieMian extends Activity {
View view456;
    View view4567;

    public static String ltid;

    public String getLtid(){

        return this.ltid;
    }

    @Override
    protected void onDestroy() {
        new sendrec().send("xx╬"+zh);
        super.onDestroy();
Log.i(".....Jiemian"," xianx");

    }

    public static Handler handler;
    public static String zh;
    ArrayList<String> liebiao;
    ArrayList<List<HaoYou>> haoyou;
    ArrayList<HaoYou> xiaoxilis;

    ArrayList<String> edxx;

    ArrayList<String> jilu;

    public String getZh(){
        return this.zh;
    }


    private void addXiaoXi() {
        ArrayList<HaoYou> lshy;
        lshy = new ArrayList<HaoYou>();
        new SqlAllChuLi(zh).selectHyData(lshy);
        for(HaoYou ls : lshy){
            if(ls.getXxzt() == 1){
                xiaoxilis.add(ls);
            }
        }
    }
    public void addXiaoZw(String zh,String id){
        jilu.clear();
        new SqlAllChuLi(zh).selectXxZw(jilu,id);
//        jilu.add("︽ffdsgdf");
//        jilu.add("︾ffdsdgdf");
//        jilu.add("︽ffdsfdggdf");
    }

    private void addHaoyou() {
        ArrayList<HaoYou> lshy;
        lshy = new ArrayList<HaoYou>();
        new SqlAllChuLi(zh).selectHyData(lshy);
        int i = 0;
        Log.i("....Jiemian",".. lshy  size....."+ lshy.size());
        new SqlAllChuLi(zh).selectLbData(liebiao);
//        Log.i("....Jiemian","...."+ liebiao.get(0));
        Log.i("....Jiemian","...size...."+ liebiao.size());

        for(String lb : liebiao){
            ArrayList<HaoYou> hyl = new ArrayList<HaoYou>();
            Log.i("....Jiemian","...cishu........"+ i++);
            Log.i("....Jiemian","...lb........"+ lb);
            for(HaoYou ls : lshy){
//                ls.setNc("ffsd");
//                ls.setQm("hhhh");
                Log.i("....Jiemian","..lbmz.."+ ls.getLbmz());
                if(lb.equals(ls.getLbmz())){
                    hyl.add(ls);
                    Log.i("....Jiemian","..lbmz....jj.."+ ls.getLbmz());
                }
            }
            haoyou.add(hyl);
            Log.i("....Jiemian","..lbmz....haoyoudddd.."+ haoyou.get(0).get(0).getNc());
//            hyl.clear();
            Log.i("....Jiemian","..lbmz....haoyousize....."+ haoyou.get(0).size());
        }

//liebiao.add("fsfs");
//        HaoYou ls = new HaoYou();
//        ls.setNc("nc");
//        ls.setQm("qm");
//        ls.setZt(0);
//        ArrayList<HaoYou> lb = new ArrayList<HaoYou>();
//        lb.add(ls);
//        haoyou.add(lb);
//        haoyou = lshaoyou;
//        Log.i("....Jiemian","..lbmz....haoyouwwwwwwwwww.."+ haoyou.get(0).get(0).getNc());

    }
    private void addEdxx(){

        String ls = AllChuLi.id;//new AllChuLi().getId();
        edxx.add(ls);

    }

    //跳转至本页面
    public static void actionStart(Context context){
        Intent it = new Intent(context,JieMian.class);
        context.startActivity(it);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jiemian);
        Intent it = getIntent();
        zh = it.getStringExtra("zh");


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                new ReceServ().rec();
//            }
//        }).start();

//        new SqlAllChuLi().deleteLbData(zh + "╬我的好友");
//        new SqlAllChuLi().deleteLbData(zh + "╬ ");
//        new ReceServ().rec();
        new sendrec().send("sx╬" + zh);
        new ReceServ().rec();
        Log.i("........jimeian...sx...","dsadfsdf");

//        for(int i = 0;i <1000000;i++);
        MyWdXxLstViewAdapter myWdXxLstViewAdapter = new MyWdXxLstViewAdapter();
        MyXoapxAdapter myXoapxAdapter = new MyXoapxAdapter();
        edxx = new ArrayList<String>();


        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case 1:
                        addEdxx();
                        LinearLayout tianjiaxx = (LinearLayout) findViewById(R.id.tianjiaxiaoxi);
                        tianjiaxx.setVisibility(View.VISIBLE);
                        ListView xx = (ListView) findViewById(R.id.wdhytj);
                        xx.setAdapter(new MyWdXxLstViewAdapter());

                        Toast.makeText(JieMian.this,"账号重复",Toast.LENGTH_LONG).show();
                        break;
                    case 2:


                        Toast.makeText(JieMian.this,"成功",Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        jilu.add("︾"+AllChuLi.zw);
                        myXoapxAdapter.notifyDataSetChanged();

                        Toast.makeText(JieMian.this,"成功",Toast.LENGTH_LONG).show();
                        break;
                    case 4:
                        xiaoxilis.add(new SqlAllChuLi(AllChuLi.id));
                        myWdXxLstViewAdapter.notifyDataSetChanged();
                        Toast.makeText(JieMian.this,"成功",Toast.LENGTH_LONG).show();
                        break;
                    case 5:
                        Toast.makeText(JieMian.this,"成功",Toast.LENGTH_LONG).show();
                        break;
                    case 6:
                        Toast.makeText(JieMian.this,"成功",Toast.LENGTH_LONG).show();
                        break;
                    case 7:
                        Toast.makeText(JieMian.this,"成功",Toast.LENGTH_LONG).show();
                        break;

                }
                // TODO
                // UI界面的更新等相关操作
            }
        };


        liebiao = new ArrayList<String>();
        haoyou = new ArrayList<List<HaoYou>>();


//        new SqlAllChuLi(zh).selectLbData(liebiao);
//        Log.i("......jiemian...",".size.."+liebiao.size());
//        Log.i("......jiemian...",".first.."+liebiao.get(0));

        xiaoxilis = new ArrayList<HaoYou>();
        addHaoyou();

//        addXiaoXi();

        TextView left = (TextView) findViewById(R.id.titleleft);
        TextView mid = (TextView) findViewById(R.id.titlemid);
        TextView right = (TextView) findViewById(R.id.titleright);

        LinearLayout xiaoxizhengwen = (LinearLayout) findViewById(R.id.xiaoxizhengwen);
        LinearLayout lianxirzw = (LinearLayout) findViewById(R.id.lianxirenzhengwen);
        LinearLayout dongtaizhengwen = (LinearLayout) findViewById(R.id.dongtaizhengwen);

        LinearLayout title = (LinearLayout) findViewById(R.id.xiaoxititle);





//----------------------------------------消息---------------------------------------------

        Button xiaoxi = (Button) findViewById(R.id.xiaoxi);

        ListView lis = (ListView) findViewById(R.id.xiaoxizw);

        lis.setAdapter(myWdXxLstViewAdapter);
        xiaoxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xiaoxizhengwen.setVisibility(View.VISIBLE);
                lianxirzw.setVisibility(View.GONE);
                dongtaizhengwen.setVisibility(View.GONE);

                left.setVisibility(View.VISIBLE);
                mid.setVisibility(View.GONE);
                right.setVisibility(View.GONE);
            }
        });




//-----------------------------------------联系人--------------------------------------------




        Button lianxiren = (Button) findViewById(R.id.lianxiren);
        LinearLayout jiemian = (LinearLayout) findViewById(R.id.tianjiajm);


        LinearLayout liaotzw = (LinearLayout) findViewById(R.id.liaotian);
        ExpandableListView exlis = (ExpandableListView) findViewById(R.id.liebiao);
        exlis.setGroupIndicator(null);
        exlis.setAdapter(new MyHyAdapter());
        exlis.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                HaoYou hys = haoyou.get(i).get(i1);
                jilu = new ArrayList<String>();
                liaotzw.setVisibility(View.VISIBLE);
                new SqlAllChuLi(zh).updataHyXxData(hys.getId(),1);
                if(!pandcf(hys)){
                    xiaoxilis.add(hys);
                    myWdXxLstViewAdapter.notifyDataSetChanged();
                }
                left.setText(hys.getNc());
                right.setText(hys.getNc());
                mid.setText(hys.getNc());

                ltid = hys.getId();
                ListView xxzw = (ListView) findViewById(R.id.liaotianlis);
                addXiaoZw(zh,hys.getId());
                ltid = hys.getId();



                xxzw.setAdapter(myXoapxAdapter);
//                xxzw.smoothScrollToPosition(0);//移动到首部

//                xxzw.smoothScrollToPosition(xxzw.getCount() - 1);//移动到尾部
                Button fasong = (Button) findViewById(R.id.fasong);

                fasong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TextView nw = (TextView) findViewById(R.id.liaoitanneir);
                        jilu.add("︽"+nw.getText().toString());
                        myXoapxAdapter.notifyDataSetChanged();
                        new sendrec().send("lt╬"+zh+"╬"+hys.getId()+"╬"+nw.getText().toString());
                        new ReceServ().rec();
                    }
                });

                return true;
            }
        });



        lianxiren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xiaoxizhengwen.setVisibility(View.GONE);
                lianxirzw.setVisibility(View.VISIBLE);
                dongtaizhengwen.setVisibility(View.GONE);

                left.setVisibility(View.GONE);
                mid.setVisibility(View.VISIBLE);
                right.setVisibility(View.GONE);

                Button tianj = (Button) findViewById(R.id.tianjia);

                tianj.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        jiemian.setVisibility(View.VISIBLE);
                        Button tianjiahy = (Button) findViewById(R.id.tianjiahy);
                        TextView hm = (TextView) findViewById(R.id.tianjiaedi);
                        tianjiahy.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                new sendrec().send("tj╬"+zh+"╬"+hm.getText().toString()+"╬awsw");

                            }
                        });

                    }
                });

            }
        });



//--------------------------------------------动态-----------------------------------------

        Button dongtai = (Button) findViewById(R.id.dongtai);
        dongtai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xiaoxizhengwen.setVisibility(View.GONE);
                lianxirzw.setVisibility(View.GONE);
                dongtaizhengwen.setVisibility(View.VISIBLE);

                left.setVisibility(View.GONE);
                mid.setVisibility(View.GONE);
                right.setVisibility(View.VISIBLE);
            }
        });
    }
    boolean pandcf(HaoYou haoYou){

        Iterator<HaoYou> it =  xiaoxilis.iterator();
        while (it.hasNext()){
            if(it.next().getId().equals(haoYou.getId())){
                return true;
            }
        }
return false;
    }
//----------------------------------------消息正文Adapter---------------------------------------------

    class MyXoapxAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return jilu.size();
        }

        @Override
        public Object getItem(int i) {
            return jilu.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            Log.i("jiemian xxzw ","jilu:"+jilu.get(i).toString());

            ViewHolder viewHolder = new ViewHolder();
            String hy = jilu.get(i).toString();
            char[] ch = hy.toCharArray();
            Log.i("jiemian xxzw ","ch length:"+ch.length);
            LayoutInflater layoutInflater = getLayoutInflater();
//            if (view == null) {
////                LayoutInflater layoutInflater = getLayoutInflater();
//                if(String.valueOf(ch[0]).equals("︾")){
//                    view456 = layoutInflater.inflate(R.layout.xiaoxileft, viewGroup, false);
//                }
//                if (String.valueOf(ch[0]).equals("︽")) {
//                    view4567 = layoutInflater.inflate(R.layout.xiaoxiright, viewGroup, false);
//                }
//
//                 // 将ViewHolder存储在View中
//            }
            if(String.valueOf(ch[0]).equals("︾")){
                view456 = layoutInflater.inflate(R.layout.xiaoxileft, viewGroup, false);
            }
            if(String.valueOf(ch[0]).equals("︽")){
                view4567 = layoutInflater.inflate(R.layout.xiaoxiright, viewGroup, false);
            }

            if(String.valueOf(ch[0]).equals("︾")){
                view = view456;
                TextView fruittext1 = (TextView) view.findViewById(R.id.xxleft);
                Log.i("jiemian xxzw ","zuizhong:"+String.copyValueOf(ch, 1, ch.length-1));
//                viewHolder.fruittext1.setText(String.copyValueOf(ch,1,ch.length));
//                if(ch.length > 1)
                    fruittext1.setText(String.copyValueOf(ch,1,ch.length-1));
            }
            if(String.valueOf(ch[0]).equals("︽")){
                view = view4567;
                TextView fruittext2 = (TextView)view.findViewById(R.id.xxright);
                Log.i("jiemian xxzw ","textview:"+fruittext2);
                Log.i("jiemian xxzw ","zuizhong:"+String.copyValueOf(ch, 1, ch.length-1));
//                viewHolder.fruittext1.setText(String.copyValueOf(ch, 1, ch.length));
//                if(ch.length > 1)
                    fruittext2.setText(String.copyValueOf(ch,1,ch.length-1));
            }


//            viewHolder.fruittext2.setText(hy.getZw());
//            viewHolder.fruittext3.setText(hy.getXxzt());

            return view;
        }
        class ViewHolder {
            TextView fruittext1;
            TextView fruittext2;
            View view1;
            View view2;
//            TextView fruittext3;
        }
    }


//----------------------------------------消息Adapter---------------------------------------------

    class MyLstViewAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return xiaoxilis.size();
        }

        @Override
        public Object getItem(int i) {
            return xiaoxilis.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            View convertView;
            if (view == null) {
                LayoutInflater layoutInflater = getLayoutInflater();
                convertView = layoutInflater.inflate(R.layout.listv, viewGroup, false);
                viewHolder = new ViewHolder();
                viewHolder.fruittext1 = (TextView) view.findViewById
                        (R.id.tex1);
                viewHolder.fruittext2 = (TextView) view.findViewById
                        (R.id.tex2);
                viewHolder.fruittext3 = (TextView) view.findViewById
                        (R.id.tex3);
                convertView.setTag(viewHolder); // 将ViewHolder存储在View中
            }else {
                convertView = view;
                viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
            }
            HaoYou hy = xiaoxilis.get(i);
            viewHolder.fruittext1.setText(hy.getNc());
            viewHolder.fruittext2.setText(hy.getZw());
            viewHolder.fruittext3.setText(hy.getXxzt());

            return view;
        }
        class ViewHolder {
            TextView fruittext1;
            TextView fruittext2;
            TextView fruittext3;
        }
    }
//----------------------------------------未读消息Adapter---------------------------------------------

    class MyWdXxLstViewAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return edxx.size();
        }

        @Override
        public Object getItem(int i) {
            return edxx.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            View convertView;
            if (view == null) {
                LayoutInflater layoutInflater = getLayoutInflater();
                view = layoutInflater.inflate(R.layout.haoyoutj, viewGroup, false);
                viewHolder = new ViewHolder();
                viewHolder.fruittext1 = (TextView) view.findViewById
                        (R.id.tjhytex1);
                viewHolder.fruittext2 = (Button) view.findViewById
                        (R.id.tongyi);
                viewHolder.fruittext3 = (Button) view.findViewById
                        (R.id.jujue);
                view.setTag(viewHolder); // 将ViewHolder存储在View中
            }else {
                convertView = view;
                viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
            }
            HaoYou hy = xiaoxilis.get(i);
            viewHolder.fruittext1.setText(hy.getNc());
            viewHolder.fruittext2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new sendrec().send("tp╬"+edxx.get(i)+"╬"+zh+"╬ty");
                }
            });
            viewHolder.fruittext3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new sendrec().send("tp╬"+edxx.get(i)+"╬"+zh+"╬jj");
                }
            });

            return view;
        }
        class ViewHolder {
            TextView fruittext1;
            Button fruittext2;
            Button fruittext3;
        }
    }



//----------------------------------------联系人Adapter---------------------------------------------
    class MyHyAdapter extends BaseExpandableListAdapter{

        @Override
        public int getGroupCount() {
            return liebiao.size();
        }

        @Override
        public int getChildrenCount(int i) {
            return haoyou.get(i).size();
        }

        @Override
        public Object getGroup(int i) {
            return getGroup(i);
        }

        @Override
        public Object getChild(int i, int i1) {
            return haoyou.get(i).get(i1);
        }

        @Override
        public long getGroupId(int i) {
            return i;
        }

        @Override
        public long getChildId(int i, int i1) {
            return i1;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            if(view == null){
                LayoutInflater layoutInflater = getLayoutInflater();
                view = layoutInflater.inflate(R.layout.parent, viewGroup, false);
            }
            TextView text1 = (TextView) view.findViewById(R.id.ptex1);
            String string = liebiao.get(i);
            text1.setText(string);

            return view;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {

            if(view == null){
                LayoutInflater layoutInflater = getLayoutInflater();
                view = layoutInflater.inflate(R.layout.listv, viewGroup, false);
            }
            TextView text1 = (TextView) view.findViewById(R.id.tex1);
            TextView text2 = (TextView) view.findViewById(R.id.tex2);
            TextView text3 = (TextView) view.findViewById(R.id.tex3);
            HaoYou hy = haoyou.get(i).get(i1);
            view.setTag(R.id.tex1,i);
            view.setTag(R.id.tex2,i1);
            text1.setText(hy.getNc());
            text2.setText(hy.getQm());
            text3.setText(Integer.toString(hy.getZt()));

            return view;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return true;
        }
    }
}
