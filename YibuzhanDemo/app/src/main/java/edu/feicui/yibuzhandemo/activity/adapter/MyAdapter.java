package edu.feicui.yibuzhandemo.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.feicui.yibuzhandemo.R;

/**
 * Created by MMQ on 2016/7/11.
 */
public class MyAdapter extends BaseAdapter {
    Context Ct;
    List<String> strList;

    public MyAdapter(Context ct) {
        Ct = ct;
        strList=new ArrayList<>();
    }

    public List<String> getStrList() {
        return strList;
    }

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    @Override
    public int getCount() {
        return strList.size();

    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        VH vh=null;
        if(convertView==null){
            convertView= LayoutInflater.from(Ct).inflate(R.layout.home_lv_item,null);
            vh=new VH();
            vh.textView= (TextView) convertView.findViewById(R.id.home_lv_item_tv);
            convertView.setTag(vh);

        }else{
            vh= (VH) convertView.getTag();

        }
            vh.textView.setText(strList.get(position));
        return convertView;
    }
    class  VH{
        TextView textView;
    }
}
