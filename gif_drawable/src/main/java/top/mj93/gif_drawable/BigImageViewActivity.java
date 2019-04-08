package top.mj93.gif_drawable;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.big_image);
        String url = getIntent().getStringExtra("url");
        final ImageView bigImage = findViewById(R.id.big_image);
//        GlideApp.with(this).asGifSo().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).load(url).into(bigImage);
        Glide.with(this).asFile().load(url).into(new SimpleTarget<File>() {
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
}
