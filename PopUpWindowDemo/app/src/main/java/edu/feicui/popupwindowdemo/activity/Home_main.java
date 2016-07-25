package edu.feicui.popupwindowdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import edu.feicui.popupwindowdemo.R;

/**
 * Created by MMQ on 2016/7/14.
 */
public class Home_main extends AppCompatActivity {
    PopupWindow popupWindow;//用来自定义弹出框

    View view;//弹出的视图，用view 来find

    LinearLayout item_LL;
    Button home_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout();
        getView();
        setView();
    }
    public void setLayout(){
        setContentView(R.layout.home_main);

    };

    public void getView(){
        home_btn= (Button) findViewById(R.id.home_main_btn);

        //获取弹出的布局
        view= LayoutInflater.from(this).inflate(R.layout.home_item,null);

        item_LL= (LinearLayout) view.findViewById(R.id.home_item_ll);
    };

    public void setView(){
        popupWindow=new PopupWindow(view,300,300);//实例化，后面代表款高度

        //设置背景，这样点击外面也可以直接关闭弹出框
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
        //触摸非弹出框的区域就可以消失，前提是必须设置背景，但是回合btn的点击冲突。
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);//让他获得焦点，避免和btn的冲突，其实没有点到btn，还是外部，伪实现效果
        //点击btn的事件，弹出弹出框
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //popupWindow的属性，显示和隐藏，返回true表示为显示，点击摧毁
                //没有的话就显示
                if(popupWindow.isShowing()){
                    popupWindow.dismiss();//摧毁它
                }else{
                    /*
                    显示，第一个传view，第二个是布局的位置，现在是在下面，
                    后面两个是偏移量，一个是x一个是y
                     */
                    popupWindow.showAtLocation(v, Gravity.BOTTOM,0,0);
                }
            }
        });

    };
}
