package mq.nsu.mymessagesdk;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Toolbar mToolbar;
    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;

    EditText userName_Edt, yanZheng_Edt;
    Button yanZHeng_Btn, login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getView();
        setView();

    }


    public void getView() {
        mToolbar= (Toolbar) findViewById(R.id.home_main_tool);
        mDrawerLayout= (DrawerLayout) findViewById(R.id.home_main_drawer);
        userName_Edt= (EditText) findViewById(R.id.homme_menu_userName_Edt);
        yanZheng_Edt= (EditText) findViewById(R.id.home_menu_MessageShow_Edt);
        yanZHeng_Btn= (Button) findViewById(R.id.home_menu_Message_Btn);
        login_btn= (Button) findViewById(R.id.home_menu_login_Btn);
    }



    public void setView() {
        mToolbar.setTitle("一级标题");
        mToolbar.setSubtitle("二级标题");


        setSupportActionBar(mToolbar);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,mDrawerLayout,mToolbar, R.string.open,R.string.close);
        actionBarDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(actionBarDrawerToggle);
    }


}
