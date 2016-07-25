package http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by MMQ on 2016/6/15.
 */
public class HttpDemo  {

    public static void getHttpPost(String path,String menuName){
        String result=null;
        StringBuffer sb=new StringBuffer();
        try {
            URL url=new URL(path);

            try {
                HttpURLConnection connection= (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");//改变打开的方式为POST,默认为get
                connection.setUseCaches(false);//是否使用缓冲，默认是true，现在改为false
                String data="Key=beaa2ce238b69744886d74f18d0f0285"+"" //前面是申请的Key
                        + "menu="+ URLEncoder.encode(menuName,"UTF-8");  //这是传入的名字，这里是菜名，修改字符格式utf-8
                byte b[]=data.getBytes();//把String 类型转换为byte类型，用于读写

                connection.setRequestProperty("Content-Type","application/x-www-from-urlencoded");//固定的格式
                connection.setRequestProperty("Content-Length",String.valueOf(b.length));//长度

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
