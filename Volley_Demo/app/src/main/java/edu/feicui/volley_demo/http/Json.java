package edu.feicui.volley_demo.http;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MMQ on 2016/7/12.
 */
public class Json {


    public List<String> getJson(String str){
        List<String> list=new ArrayList<>();
        String data=null;
        try {
            JSONObject js=new JSONObject(str);
            JSONObject result=js.getJSONObject("result");
            JSONArray datas= result.getJSONArray("data");
            for (int i=0;i<datas.length();i++){
                JSONObject tittle=datas.getJSONObject(i);
                list.add(tittle.getString("title"));

                Log.i("mq",tittle.getString("title")+"mqmq");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

}
