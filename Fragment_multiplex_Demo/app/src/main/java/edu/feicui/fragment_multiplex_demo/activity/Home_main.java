package edu.feicui.fragment_multiplex_demo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.LinearLayout;

import edu.feicui.fragment_multiplex_demo.R;
import edu.feicui.fragment_multiplex_demo.fragment.A_fragment;

/**
 * Created by MMQ on 2016/6/13.
 */
public class Home_main extends FragmentActivity  {
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main);
        linearLayout= (LinearLayout) findViewById(R.id.home_main_ll);

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.home_main_ll,new A_fragment());
        ft.commit();
    }
}
