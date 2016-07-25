package edu.feicui.yibuzhandemo.activity.activity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.feicui.yibuzhandemo.activity.adapter.MyAdapter;
import edu.feicui.yibuzhandemo.R;

/**
 * Created by MMQ on 2016/7/11.
 */
public class Home_main extends Activity {
    Button btn;
    MyAdapter myAdapter;
    List<String> strList;
    ListView listView;
    TextView textView;

    int sum;//这是一个中间变量，为了看出效果
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main);
        getView();
        setView();
    }

    public void getView(){
        myAdapter=new MyAdapter(this);
        strList=new ArrayList<>();

        btn= (Button) findViewById(R.id.home_main_btn);
        listView= (ListView) findViewById(R.id.home_main_lv);
        textView= (TextView) findViewById(R.id.home_main_tv);


    };
    public void setView(){
        listView.setAdapter(myAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new MyTask().execute();//启动方法
            }
        });

    };

    class MyTask extends AsyncTask<Void,Void,Void>{

        @Override
        //运行时的方法
        protected Void doInBackground(Void... params) {


            for (int i=0; i<5;i++){
                strList.add("这是第"+sum+"个");
                publishProgress();//调用之后直接进入更新方法，可以实现一条条显示
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sum++;
            }
            return null;
        }


        //运行结束
        @Override
        protected void onPostExecute(Void aVoid) {
            textView.setText("运行结束方法，执行完成");

            //            strList.clear();//清空整个集合，不然下次点击还有之前的数据

            super.onPostExecute(aVoid);
        }


        //更新
        @Override
        protected void onProgressUpdate(Void... values) {
            myAdapter.setStrList(strList);
            myAdapter.notifyDataSetChanged();

            super.onProgressUpdate(values);
        }

        //运行前准备
        @Override
        protected void onPreExecute() {
            textView.setText("运行前准备方法，开始加载");
            super.onPreExecute();
        }
    }
}

