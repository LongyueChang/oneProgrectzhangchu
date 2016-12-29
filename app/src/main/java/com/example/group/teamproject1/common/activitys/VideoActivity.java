package com.example.group.teamproject1.common.activitys;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dou361.ijkplayer.listener.OnShowThumbnailListener;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.example.group.teamproject1.R;

public class VideoActivity extends AppCompatActivity {
    private PlayerView playerView;
    private View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rootView=getLayoutInflater().from(this).inflate(R.layout.simple_player_view_player,null);
        setContentView(rootView);

        initView();



    }

    private void initView() {
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String videoPath = extras.getString("video");
        final String imagePath = extras.getString("image");

        playerView=new PlayerView(this);
        playerView.setTitle("视频播放");
        playerView.setScaleType(PlayStateParams.fillparent);
        playerView.hideMenu(true);

        playerView.showThumbnail(new OnShowThumbnailListener() {
            @Override
            public void onShowThumbnail(ImageView ivThumbnail) {
                Glide.with(VideoActivity.this)
                        .load(imagePath)
                        .placeholder(R.mipmap.placeholder)
                        .error(android.R.drawable.stat_notify_error)
                        .into(ivThumbnail);
            }
        });

        playerView.setPlaySource(videoPath);
        playerView.startPlay();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (playerView != null) {
            playerView.onPause();
        }
        /**demo的内容，恢复系统其它媒体的状态*/
        //MediaUtils.muteAudioFocus(mContext, true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (playerView != null) {
            playerView.onResume();
        }
        /**demo的内容，暂停系统其它媒体的状态*/
//        MediaU.muteAudioFocus(this, false);
        /**demo的内容，激活设备常亮状态*/
        //if (wakeLock != null) {
        //    wakeLock.acquire();
        //}
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (playerView != null) {
            playerView.onDestroy();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (playerView != null) {
            playerView.onConfigurationChanged(newConfig);
        }
    }

    @Override
    public void onBackPressed() {
        if (playerView != null && playerView.onBackPressed()) {
            return;
        }
        super.onBackPressed();
        /**demo的内容，恢复设备亮度状态*/
        //if (wakeLock != null) {
        //    wakeLock.release();
        //}
    }

}
