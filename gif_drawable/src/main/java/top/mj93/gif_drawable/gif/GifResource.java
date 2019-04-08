package top.mj93.gif_drawable.gif;

import android.support.annotation.NonNull;

import com.bumptech.glide.load.engine.Resource;

import pl.droidsonroids.gif.GifDrawable;

/**
 * @author liumengjie
 * @version V1.0
 * @Title: ${file_name}
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/4/3 22:12
 */
public class GifResource implements Resource<GifDrawable> {

    private GifDrawable mDrawable;

    public GifResource(GifDrawable mDrawable) {
        this.mDrawable = mDrawable;
    }

    @NonNull
    @Override
    public Class<GifDrawable> getResourceClass() {
        return GifDrawable.class;
    }

    @NonNull
    @Override
    public GifDrawable get() {
        return mDrawable;
    }

    @Override
    public int getSize() {
        return (int) mDrawable.getInputSourceByteCount();
    }

    @Override
    public void recycle() {
        mDrawable.stop();
        mDrawable.recycle();
    }
}
