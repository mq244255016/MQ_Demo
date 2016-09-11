package edu.feicui.ormlitedata.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.feicui.ormlitedata.R;
import edu.feicui.ormlitedata.db.DbBiao;
import edu.feicui.ormlitedata.db.DbDo;
import edu.feicui.ormlitedata.db.DbOrmLiteHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button add,delete,findAll;
    TextView show;
    DbDo dbDo;//数据库操作类
    List<DbBiao> list;//用来装返回数据的list
//    DbOrmLiteHelper dbOrmLiteHelper;//数据库创建类


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add= (Button) findViewById(R.id.home_add);
        delete= (Button) findViewById(R.id.home_delete);
        findAll= (Button) findViewById(R.id.home_find);
        show= (TextView) findViewById(R.id.home_show);
        setView();
    }

    public void setView(){

        /**这是数据库操作类的实例化，里面传入的数据库的创建类的对象*/
        dbDo=new DbDo(DbOrmLiteHelper.getInstant(this));
        add.setOnClickListener(this);
        delete.setOnClickListener(this);
        findAll.setOnClickListener(this);
        list=new ArrayList<>();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.home_add:
                dbDo.createOrUpdate(new DbBiao("马强","男"));
                break;
            case R.id.home_delete:
               Long id= Long.valueOf(0);
                dbDo.deleteforId(id);

                break;
            case R.id.home_find:
               list= dbDo.findAll();
                show.setText(list.toString());
                break;
        }
    }
}
