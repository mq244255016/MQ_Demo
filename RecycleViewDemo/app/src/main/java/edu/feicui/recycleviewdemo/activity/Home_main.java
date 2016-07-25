package edu.feicui.recycleviewdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.feicui.recycleviewdemo.R;
import edu.feicui.recycleviewdemo.adapter.Myadapter;

/**
 * Created by MMQ on 2016/7/12.
 */
public class Home_main extends AppCompatActivity{
    RecyclerView recyclerView;
    List<String> strList;
    Myadapter myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout();
        getView();
        setView();
    }

    public void setLayout(){
        setContentView(R.layout.home_main);
        strList=new ArrayList<>();
        loadData();
    };

    public void getView(){
        recyclerView= (RecyclerView) findViewById(R.id.home_main_recycler);

    };

    public void setView(){
        //布局方式，正常的线性排列
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //表格布局，传入上下文和一行有多少个
//        recyclerView.setLayoutManager(new GridLayoutManager(this,3));

        //瀑布布局 ，第一个代表一行一个，第二个是排列方式，横或者纵
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));


       /*
       适配器中自定义的点击，通过适配器调用
        */
        myadapter=new Myadapter(this,strList);
        myadapter.setRecycleViewClick(new Myadapter.RecyclerViewClick() {
            @Override
            public void OnitemClick(View view, int position) {
                Toast.makeText(Home_main.this,"这是短按点击",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnitemLongClick(View view, int position) {
                Toast.makeText(Home_main.this,"这是长按点击",Toast.LENGTH_SHORT).show();

            }
        });



        recyclerView.setAdapter(myadapter);

    };

    public void loadData(){
        for (int i=0;i<50;i++){
            strList.add("这是第"+i+"个马强");
        }
    }
}
