package com.demo.mark.m3u8_video_demo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.demo.mark.m3u8_video_demo.player.VideoActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";

    Button play_url_m3u8;

    Button play_location_m3u8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        play_url_m3u8 = (Button) findViewById(R.id.play_url_m3u8);
        play_location_m3u8 = (Button) findViewById(R.id.play_location_m3u8);

        play_url_m3u8.setOnClickListener(clickListener);
        play_location_m3u8.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.play_url_m3u8) {
                // TODO 确保此网络文件可用
//                String path2 = "http://ad.i5suoi.com/video/94.m3u8";
//                String path2 = "http://devimages.apple.com/iphone/samples/bipbop/gear1/prog_index.m3u8";
                String path2 = "http://ziqi.hotyoso.com/v/135/159/2/0/04a4c9c63f9748eb8323032d345d911b/848X480/04a4c9c63f9748eb8323032d345d911b.m3u8";
                Log.i(TAG, "path2 : "+path2);
                playVideo(path2, "播放网络M3U8");
            } else if (id == R.id.play_location_m3u8) {
                // TODO 确保本地存在此文件
                // TODO 代理服务器地址，加本地存储地址
//                String path3 = Environment.getExternalStorageState() + "/prog_index.m3u8";
//                String path3 = getAssetsCacheFile(MainActivity.this,"prog_index.m3u8");
                String path3 = "file:///android_asset/prog_index.m3u8";

                Log.i(TAG, "path3 : "+path3);
                playVideo(path3, "播放本地M3U8");
            }
        }
    };


    private void playVideo(String source, String title) {
        if (source == null || source.equals("")) {
            Toast.makeText(this, "视频内容不存在！", Toast.LENGTH_LONG).show();
            source = "http://ad.i5suoi.com/video/94.m3u8";
            Intent intent = new Intent(this, VideoActivity.class);
            intent.setData(Uri.parse(source));
            intent.putExtra("mVideoTitle", title);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, VideoActivity.class);
            intent.setData(Uri.parse(source));
            intent.putExtra("mVideoTitle", title);
            startActivity(intent);
        }
    }
    public void toSecondAc(View view){
        startActivity(new Intent(this,SecondActivity.class));
    }


}
