package top.mj93.gif_drawable;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.io.File;
import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;

/**
 * @author liumengjie
 * @version V1.0
 * @Title: ${file_name}
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/4/5 14:00
 */
public class BigImageViewActivity extends Activity {
     ImageView bigImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.big_image);
        String url = getIntent().getStringExtra("url");
       bigImage = findViewById(R.id.big_image);
        Glide.with(this).downloadOnly().load(url).into(new SimpleTarget<File>() {
            @Override
            public void onResourceReady(@NonNull File resource, @Nullable Transition<? super File> transition) {
                try {
                    bigImage.setImageDrawable(new GifDrawable(resource));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Glide.with(this).resumeRequests();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Glide.with(this).pauseRequests();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Glide.with(this).onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Glide.with(this).onStop();
    }

    @Override
    protected void onDestroy() {
        Drawable drawable = bigImage.getDrawable();
        if(drawable instanceof GifDrawable){
            ((GifDrawable) drawable).stop();
            ((GifDrawable) drawable).recycle();
        }
        super.onDestroy();
    }
}
