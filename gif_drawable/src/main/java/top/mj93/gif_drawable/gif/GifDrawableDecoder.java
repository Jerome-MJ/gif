package top.mj93.gif_drawable.gif;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

import java.io.IOException;
import java.io.InputStream;

import pl.droidsonroids.gif.GifDrawable;

/**
 * @author liumengjie
 * @version V1.0
 * @Title: ${file_name}
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/4/3 22:11
 */
public class GifDrawableDecoder implements ResourceDecoder<InputStream, GifDrawable> {

    private BitmapPool mBitmapPool;

    public GifDrawableDecoder(BitmapPool bitmapPool) {
        this.mBitmapPool = bitmapPool;
    }

    /**
     * 判断是否正常显示 gif
     *
     * @param source
     * @param options
     * @return
     * @throws IOException
     */
    @Override
    public boolean handles(@NonNull InputStream source, @NonNull Options options) throws IOException {
        return true;
    }

    @Nullable
    @Override
    public Resource<GifDrawable> decode(@NonNull InputStream source, int width, int height, @NonNull Options options) throws IOException {
        GifDrawable gifDrawable = new GifDrawable(source);
        return new GifResource(gifDrawable);
    }
}
