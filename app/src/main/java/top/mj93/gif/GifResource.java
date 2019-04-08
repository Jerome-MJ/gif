package top.mj93.gif;

import android.support.annotation.NonNull;

import com.bumptech.glide.load.engine.Resource;

import android.support.rastermill.FrameSequenceDrawable;

/**
 * @author liumengjie
 * @version V1.0
 * @Title: ${file_name}
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/4/3 22:12
 */
public class GifResource implements Resource<FrameSequenceDrawable> {

    private FrameSequenceDrawable mDrawable;

    public GifResource(FrameSequenceDrawable mDrawable) {
        this.mDrawable = mDrawable;
    }

    @NonNull
    @Override
    public Class<FrameSequenceDrawable> getResourceClass() {
        return FrameSequenceDrawable.class;
    }

    @NonNull
    @Override
    public FrameSequenceDrawable get() {
        return mDrawable;
    }

    @Override
    public int getSize() {
        return mDrawable.getSize();
    }

    @Override
    public void recycle() {
        mDrawable.stop();
        mDrawable.destroy();
    }
}
