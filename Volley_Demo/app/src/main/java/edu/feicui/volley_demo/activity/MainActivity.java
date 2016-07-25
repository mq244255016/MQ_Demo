package edu.feicui.volley_demo.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.List;

import edu.feicui.volley_demo.R;
import edu.feicui.volley_demo.http.Json;
import edu.feicui.volley_demo.http.VolleySingleton;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<String> list;
//    MyAdapter ma;
    Button text_btn,img_btn;
    ImageView iv;
    TextView tv;
    Json myJson;
    List<String> jsonList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main);
        jsonList=new ArrayList<>();
        myJson=new Json();
        text_btn= (Button) findViewById(R.id.home_main_one_btn);
        img_btn= (Button) findViewById(R.id.home_main_two_btn);
        iv= (ImageView) findViewById(R.id.home_main_img);
        tv= (TextView) findViewById(R.id.home_main_tv);

        text_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getResult();
            }
        });
        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddBitmap();
            }
        });
//        loaddata();
//        recyclerView= (RecyclerView) findViewById(R.id.my_recycle);
////        recyclerView.setLayoutManager(new LinearLayoutManager(this));
////        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
//        ma=new MyAdapter(this,list);
//        recyclerView.addItemDecoration(new MyItem(this,LinearLayoutManager
//                .HORIZONTAL,5, Color.TRANSPARENT));
//        ma.setRecycleViewClickListener(new MyAdapter.RecycleViewClickListener() {
//            @Override
//            public void OnItemClick(View view, int position) {
////                Toast.makeText(MainActivity.this,"短按",Toast.LENGTH_SHORT).show();
//                ma.add(5,"李林");
//            }
//
//            @Override
//            public void OnItemLongClick(View view, int position) {
////                Toast.makeText(MainActivity.this,"长按",Toast.LENGTH_SHORT).show();
//                ma.remove(position);
//            }
//        });
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(ma);


//
//        recyclerView.setAdapter();
    }
    void loaddata(){
        list=new ArrayList<String>();
        for (int i=0;i<50;i++){
            list.add("这是第"+i+"条数据");
        }
    }
    //    public StringRequest(String url, com.android.volley.Response.Listener<java.lang.String> listener, com.android.volley.Response.ErrorListener errorListener);
//    public StringRequest(int method, java.lang.String url, com.android.volley.Response.Listener<java.lang.String> listener, com.android.volley.Response.ErrorListener errorListener);
//    参数method是HTTP的请求类型，
// 通常有GET和POST两种；
// 参数url是请求地址；
// 参数listener是服务器响应成功的回调，
// 参数errorListener是服务器响应失败的回调
// 。如果想通过POST方式请求并携带参数
// ，遗憾的是StringRequest并没有提供带参数请求，
// 但是当发送POST请求时，Volley会调用StringRequest的父类Request的getParams()方法来获取POST参数，
// 所以我们只要使用StringRequest匿名类重写getParams()方法将参数传递进去就可以实现带参数的StringRequest请求。
    public void getResult(){
        //发送StringRequest请求
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                "http://v.juhe.cn/toutiao/index?type=top&key=1411926b8ab01c4a8adc923b4b46fbb9",
                new Response.Listener<String>(){

                    @Override
                    public void onResponse(String s) {
                        //打印请求返回结果
                        Log.i("volley",s);
                       jsonList= myJson.getJson(s);
                        StringBuffer sb=new StringBuffer();
                        String str=null;
                        for (int i=0;i<jsonList.size();i++){
                            Log.i("cs", jsonList.get(i));
                          sb.append(jsonList.get(i));

                        }
                        str=sb.toString();
                        tv.setText(str);



                    }
                },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.i("volleyerror", "erro2");
            }
        });
//将StringRequest对象添加进RequestQueue请求队列中
        VolleySingleton.getVolleySingleton(this.getApplicationContext()).addToRequestQueue(stringRequest);
//        StringRequest stringRequest = new StringRequest(Method.POST, url,  listener, errorListener) {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> map = new HashMap<String, String>();
//                map.put("params1", "value1");
//                map.put("params2", "value2");
//                return map;//这里用于拼接
//            }
//        };
        //获取JSONOBject实例
//        JsonObjectRequest jr = new JsonObjectRequest(Request.Method.GET,url,null,new Response.Listener<JSONObject>(){
//            @Override
//            public void onResponse(JSONObject jsonObject) {
//                Log.e("volley",jsonObject.toString());
//            }
//        },new ErrorListener(){
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//                Log.e("volleyerror","erro");
//            }
//        });
//        VolleySingleton.getVolleySingleton(this.getApplicationContext()).addToRequestQueue(jr);
    }
    //    public ImageRequest(java.lang.String url, com.android.volley.Response.Listener<android.graphics.Bitmap> listener, int maxWidth, int maxHeight, android.graphics.Bitmap.Config decodeConfig, com.android.volley.Response.ErrorListener errorListener)
//    参数url是图片地址，参数listener是请求响应成功回调，
// 参数maxWidth是图片最大宽度，
// 参数maxHeight是图片最大高度，
// 如果指定的网络图片的宽度或高度大于这里的最大值，则会对图片进行压缩，
// 指定成0的话就表示不管图片有多大，都不会进行压缩。
// 参数decodeConfig是图片的颜色属性，其值是Bitmap.Config类的几个常量，参数errorListener是请求响应失败回调
    public void AddBitmap(){
        String url = "http://dl.bizhi.sogou.com/images/2013/10/30/396486.jpg";

        ImageRequest request = new ImageRequest(url,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        iv.setImageBitmap(bitmap);
                    }
                }, 0, 0, Bitmap.Config.RGB_565,
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        iv.setImageResource(R.mipmap.ic_launcher);//加载失败
                    }
                });
        VolleySingleton.getVolleySingleton(this.getApplicationContext()).addToRequestQueue(request);
    }
//    <com.android.volley.toolbox.NetworkImageView
//    android:id="@+id/networkImageView"
//    android:layout_width="150dp"
//    android:layout_height="170dp"
//    android:layout_centerHorizontal="true" />

//    ImageLoader mImageLoader;
//    NetworkImageView mNetworkImageView;
//    private static final String IMAGE_URL =
//            "http://developer.android.com/images/training/system-ui.png";
//    mNetworkImageView = (NetworkImageView) findViewById(R.id.networkImageView);
//    mImageLoader = VolleySingleton.getVolleySingleton(this.getApplicationContext()).getImageLoader();
//    mNetworkImageView.setImageUrl(IMAGE_URL, mImageLoader);
//
//            7
//    我们可以调用它的setDefaultImageResId()方法、setErrorImageResId()方法和setImageUrl()方法来分别设置加载中显示的图片，加载失败时显示的图片

}
