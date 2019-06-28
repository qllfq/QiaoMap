package com.example.qiaolulu.qiaomap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.qiaolulu.qiaomap.activities.Activity_1;
import com.example.qiaolulu.qiaomap.activities.Activity_2;
import com.example.qiaolulu.qiaomap.activities.Activity_3;
import com.example.qiaolulu.qiaomap.activities.Activity_4;
import com.example.qiaolulu.qiaomap.activities.Activity_5;
import com.example.qiaolulu.qiaomap.javaBean.ImageSlideshow;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageSlideshow imageSlideshow;
    private List<String> imageUrlList;
    private List<String> titleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        imageSlideshow = (ImageSlideshow) findViewById(R.id.is_gallery);
        imageUrlList = new ArrayList<>();
        titleList = new ArrayList<>();

        // 初始化数据
        initData();

        // 为ImageSlideshow设置数据
        imageSlideshow.setDotSpace(12);
        imageSlideshow.setDotSize(12);
        imageSlideshow.setDelay(1000);
        imageSlideshow.setOnItemClickListener(new ImageSlideshow.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this,Activity_1.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this,Activity_2.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this,Activity_3.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this,Activity_4.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this,Activity_5.class));
                        break;
                }
            }
        });
        imageSlideshow.commit();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        int[] imageIds = new int[]{
                R.drawable.dian1,
                R.drawable.dian2,
                R.drawable.dian3,
                R.drawable.dian4,
                R.drawable.dian3

        };
        String[] imageUrls = {"http://pic3.zhimg.com/b5c5fc8e9141cb785ca3b0a1d037a9a2.jpg",
                "http://pic2.zhimg.com/551fac8833ec0f9e0a142aa2031b9b09.jpg",
                "http://pic2.zhimg.com/be6f444c9c8bc03baa8d79cecae40961.jpg",
                "http://pic1.zhimg.com/b6f59c017b43937bb85a81f9269b1ae8.jpg",
                "http://pic2.zhimg.com/a62f9985cae17fe535a99901db18eba9.jpg"};
        String[] titles = {" ",
                "  ",
                "  ",
                "  ",
                "  "};
        for (int i = 0; i < 5; i++) {
            imageSlideshow.addImageTitle(imageUrls[i], titles[i],imageIds[i]);
        }
    }

    @Override
    protected void onDestroy() {
        // 释放资源
        imageSlideshow.releaseResource();
        super.onDestroy();
    }
}
