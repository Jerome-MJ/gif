package top.mj93.gif_drawable.gif;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

import java.io.File;
import java.io.InputStream;

import pl.droidsonroids.gif.GifDrawable;

/**
 * @author liumengjie
 * @version V1.0
 * @Title: ${file_name}
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/4/3 22:08
 */
@GlideModule
public class YbGlideModel extends AppGlideModule {

    /**
     * 注册组件
     * @param context
     * @param glide
     * @param registry
     */
    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        registry.append(Registry.BUCKET_GIF,
                InputStream.class,
                GifDrawable.class,
                new GifDrawableDecoder(glide.getBitmapPool()));
        super.registerComponents(context, glide, registry);

    }
}
