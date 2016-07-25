package edu.feicui.recycleviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import edu.feicui.recycleviewdemo.R;

/**
 * Created by MMQ on 2016/7/12.
 */
public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {
    Context Ct;
    List<String> list;

    public Myadapter(Context ct, List<String> list) {
        Ct = ct;
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    /*
    用来加载布局，返回值为自定义的内部类ViewHolder,自定义类MyViewHolder的实例化
     */
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mv= LayoutInflater.from(Ct).inflate(R.layout.home_recycler_item,parent,false);
        MyViewHolder mVH=new MyViewHolder(mv);
        return mVH;
    }

    /*
    用来绑定布局,item的修改,瀑布设置宽高布局，子布局的点击事件在这定义,holder就是代表自己定义的MyViewHolder
    */
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.tv.setText(list.get(position));

        //自定义每个子item的点击事件
        if(recyclerViewClick!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int pos=holder.getLayoutPosition();

                    //子iteme点击事件，根据下标点击不同的otem
                    recyclerViewClick.OnitemClick(holder.itemView,pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos=holder.getLayoutPosition();
                    recyclerViewClick.OnitemLongClick(holder.itemView,pos);

                    return true;
                }
            });
        }
    }


    @Override

    public int getItemCount() {
        return list.size();

    }

    //接口的声明
    private RecyclerViewClick recyclerViewClick=null;

    //拿到并返回当前接口
    public RecyclerViewClick getRecycleViewClick(){
        return recyclerViewClick;
    }

    //接口RecyclerViewClick 的 set方法
    public void setRecycleViewClick(RecyclerViewClick recycleViewClick){
        this.recyclerViewClick=recycleViewClick;
    }

    /*
    自定义的内部类，可用来findViewByid
     */
    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv= (TextView) itemView.findViewById(R.id.home_recycler_item_tv);
        }
    }

/*
自定以的点击和长按点击，首先定义接口
 */
    public interface RecyclerViewClick{
        void OnitemClick(View view,int position);
        void OnitemLongClick(View view,int position);
    }
}
