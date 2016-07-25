package edu.feicui.fragment_multiplex_demo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.feicui.fragment_multiplex_demo.R;

/**
 * Created by MMQ on 2016/6/13.
 */
public class A_fragment extends Fragment implements View.OnClickListener {
    View view;
    Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.a, null);
        button= (Button) view.findViewById(R.id.a_btn);
        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.a_btn:
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.home_main_ll,new B_fragment());
                ft.addToBackStack("one");
                ft.commit();
                break;
        }


    }
}
