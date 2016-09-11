package nsu.dongruan.surface_mediaplay_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    My_SurfaceView_rl my_surfaceView_rl;//自定义的视频加载的控件
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        my_surfaceView_rl= (My_SurfaceView_rl) findViewById(R.id.home_main_surface);
        my_surfaceView_rl.setVideoPath(Path.getPath);//调用修改方法，传入地址

    }
}
