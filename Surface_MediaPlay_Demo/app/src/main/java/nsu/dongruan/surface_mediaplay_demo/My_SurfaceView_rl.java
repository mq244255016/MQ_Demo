package nsu.dongruan.surface_mediaplay_demo;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.RelativeLayout;

import java.io.IOException;

/**
 * Created by MMQ on 2016/8/9.
 * 继承相对布局，完成自己定义的布局，实现SurfaceHolder.Callback，覆写对Surface的监听
 *
 * 使用MediaPlayer+SurfaceView 完成视频的加载
 */


public class My_SurfaceView_rl extends RelativeLayout implements SurfaceHolder.Callback {

    private MediaPlayer  mediaPlayer;//这是用来播放视频的，但是不能够显示，所以要用到SurfaceView
   private SurfaceView surfaceView;//这是控制视图显示的控件

    private SurfaceHolder surfaceHolder;//SurfaceView视图的控制

    private String videoPath;//调用方法后传入的地址

    public My_SurfaceView_rl(Context context) {
        this(context, null);//这里改为调用自身的，不然是调用父类
    }

    public My_SurfaceView_rl(Context context, AttributeSet attrs) {
        this(context, attrs,0);//这里加了个 0.，不知道为什么
    }

    /*
    布局的显示控制这些在这里写
    */
    public My_SurfaceView_rl(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // 当前布局(就是一个SurfaceView)
        // 一般的需求:
        // 有SurfaceView（用来显示视频内容）
        // 有视频控制的控件(比如，播放.......)

        //加载布局，布局中有SurfaceView
        LayoutInflater.from(getContext()).inflate(R.layout.my_surface,this,true);
        surfaceView= (SurfaceView) findViewById(R.id.my_Surface_sface);

        surfaceHolder=surfaceView.getHolder();//拿到holder

        surfaceHolder.addCallback(this);
    }


    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }




    /**
     * 实现了SurfaceHolder接口覆写的三分方法*/




    @Override//创建完成
    public void surfaceCreated(SurfaceHolder holder) {

        try {
            mediaPlayer=new MediaPlayer();//实例化MediaPlayer

            mediaPlayer.setDisplay(holder);//启动视图界面的Holder

            mediaPlayer.setDataSource(videoPath);//打开的地址，这个地址就是调用的时候传入的。

            mediaPlayer.prepareAsync();//异步线程来监听视频的变化

            //进度状态变化的监听
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mediaPlayer.start();//启动
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override//改变状态
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {



    }

    @Override//结束
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
