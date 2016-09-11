package mq.nsu.load_demo;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

//这里实现的是扩展包的LoaderManager   v4
public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化Loader(如果已经存在，会自动重用)
        getSupportLoaderManager().initLoader(0, null, this);//这里记得调用supportLoad
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {MediaStore.Audio.Media._ID,//id
                MediaStore.Audio.Media.DISPLAY_NAME,//音乐名称
                MediaStore.Audio.Media.DATA,//data
                MediaStore.Audio.Media.ALBUM,//音乐专辑
                MediaStore.Audio.Media.ARTIST,//谁唱的
                MediaStore.Audio.Media.DURATION,//市场
                MediaStore.Audio.Media.SIZE//大小
        };

        return new CursorLoader(this
                , MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,//音屛数据的内容提供者URi
                projection,
                null, null, null);//游标加载器
    }

    @Override//加载完成
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        //将Cursor里面的数据拿出来
        if(cursor.moveToFirst()){

            do{
               String artist= cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                String name=cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
                Log.i("msg",name+artist);
            }while (cursor.moveToNext());


        }

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }


}
