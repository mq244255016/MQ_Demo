package tool;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import ToolBar.toolbar.R;

/**
 * Created by MMQ on 2016/7/8.
 */
public class Home_main extends AppCompatActivity {
    Toolbar toolbar;

    DrawerLayout drawerLayout;//抽屉控件

    ActionBarDrawerToggle actionBarDrawerToggle;//把ToolBar和抽屉绑定在一起的类
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main);
        getView();
        setView();
    }
    public void getView(){
        toolbar= (Toolbar) findViewById(R.id.home_main_toolBar);
        drawerLayout= (DrawerLayout) findViewById(R.id.home_main_Drawer);
    };

    public void setView(){
        //标题栏的设置
        toolbar.setTitle("这是一级标题");
        toolbar.setSubtitle("这是二级标题");
        toolbar.setLogo(R.mipmap.ic_launcher);


        setSupportActionBar(toolbar);
        /*
        这是设置右上角menu里面的属性的点击
         */
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.one_menu:
                        Toast.makeText(Home_main.this, "你点击了A", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.two_menu:
                        Toast.makeText(Home_main.this, "你点击了b", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        actionBarDrawerToggle =new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.open,R.string.close);

        actionBarDrawerToggle.syncState();//保持同步
        drawerLayout.setDrawerListener(actionBarDrawerToggle);//把抽屉和绑定的类绑定在一起


    };

    @Override
    //这是设置标题栏右上的menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
}
