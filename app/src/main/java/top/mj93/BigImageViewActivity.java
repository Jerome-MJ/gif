package top.mj93;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.rastermill.FrameSequenceDrawable;
import android.widget.ImageView;

import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import top.mj93.gif.GlideApp;

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
        GlideApp.with(this).asGifFs().load(url).into(new SimpleTarget<FrameSequenceDrawable>() {
            @Override
            public void onResourceReady(@NonNull FrameSequenceDrawable resource, @Nullable Transition<? super FrameSequenceDrawable> transition) {
                bigImage.setImageDrawable(resource);
                resource.start();
            }
        });
    }
}
