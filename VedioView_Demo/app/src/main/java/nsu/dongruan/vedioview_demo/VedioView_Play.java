package nsu.dongruan.vedioview_demo;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

/**
 * Created by MMQ on 2016/8/8.
 */
public class VedioView_Play extends AppCompatActivity
        implements MediaPlayer.OnInfoListener,
        MediaPlayer.OnBufferingUpdateListener,
        MediaPlayer.OnPreparedListener {

    //实现MediaPlayer.OnInfoListener的接口，其中int  What是加载状态，extra是加载速度

    //实现MediaPlayer.OnBufferingUpdateListener 是内存改变的监听,所占的比例

    //实现 MediaPlayer.OnPreparedListener 所占内存的监听

    VideoView videoView;//这是视频播放，其中已经封装了MediaPlayer和 SurFaceView;

    TextView load_tv, fast_Tv;
    ProgressBar load_pro;

    MediaController mediaController;//视频播放控制

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Vitamio.isInitialized(VedioView_Play.this);//网上找的方法，不加要报错
        Vitamio.isInitialized(this);
        setContentView(R.layout.vedio_play);
        videoView = (VideoView) findViewById(R.id.vedio_vedio);

        load_tv = (TextView) findViewById(R.id.vedio_load_tv);
        load_pro = (ProgressBar) findViewById(R.id.vedio_load_pro);
        fast_Tv = (TextView) findViewById(R.id.vedio_load_fast_tv);


        Uri videoURI=Uri.parse("android.resource://nsu.dongruan.vedioview_demo/"+R.raw.move);
        videoView.setVideoPath(Path.VedioPath);
        mediaController=new MediaController(this);

        videoView.start();
        videoView.setOnBufferingUpdateListener(this);//改变监听
        videoView.setOnPreparedListener(this);//内存大小监听
        videoView.setOnInfoListener(this);//内存信息监听
        videoView.setMediaController(mediaController);


    }

    @Override
    public boolean onInfo(MediaPlayer mp, int what, int extra) {
        //根据缓冲的状态来做出一些操作
        switch (what) {
            //缓冲开始的状态,调用缓冲开始前自定义的状态方法
            case MediaPlayer.MEDIA_INFO_BUFFERING_START:
                startBuffer();

                break;
            //缓冲结束的状态，调用缓冲结束前自定义的状态方法
            case MediaPlayer.MEDIA_INFO_BUFFERING_END:
                endBuffer();

                break;
            //判断缓冲状态在改变，下载速度,extra是速度
            case MediaPlayer.MEDIA_INFO_DOWNLOAD_RATE_CHANGED:
                fast_Tv.setText(extra + "k/s");
                break;
        }
        return false;
    }


    //缓冲开始前给一些视图表示正在加载
    private void startBuffer() {
//        videoView.setVisibility(View.GONE);
        load_tv.setVisibility(View.VISIBLE);
        load_pro.setVisibility(View.VISIBLE);
        fast_Tv.setVisibility(View.VISIBLE);
    }

    //缓冲结束开始播放，并把之前加载中等视图隐藏
    private void endBuffer() {
        videoView.start();
        load_tv.setVisibility(View.GONE);
        load_pro.setVisibility(View.GONE);
        fast_Tv.setVisibility(View.GONE);

    }


    //缓存所占百分比
    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {
        fast_Tv.setText(percent + "%");

    }

    //缓存所用内存空间的大小,
    @Override
    public void onPrepared(MediaPlayer mp) {
        videoView.setBufferSize(512 * 1024);
    }
}
