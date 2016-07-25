package feicui.edu.recycle_view_add_xialajiazai.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MMQ on 2016/7/19.
 */
public class Recycle_Adapter extends RecyclerView.Adapter<Recycle_Adapter.MyViewHolder> {

    Context Ct;
    List<String> list;
    final int HEAD=0;
    final int BODY=1;
    final int FOOT=2;

    public Recycle_Adapter(Context ct) {
        Ct = ct;
        list=new ArrayList<>();
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size() ;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public MyViewHolder(View itemView) {

            super(itemView);


        }
    }
}
