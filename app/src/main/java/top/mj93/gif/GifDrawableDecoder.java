package top.mj93.gif;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

import java.io.IOException;
import java.io.InputStream;

import android.support.rastermill.FrameSequence;
import android.support.rastermill.FrameSequenceDrawable;

/**
 * @author liumengjie
 * @version V1.0
 * @Title: ${file_name}
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/4/3 22:11
 */
public class GifDrawableDecoder implements ResourceDecoder<InputStream, FrameSequenceDrawable> {

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
    public Resource<FrameSequenceDrawable> decode(@NonNull InputStream source, int width, int height, @NonNull Options options) throws IOException {
        FrameSequence frameSequence = FrameSequence.decodeStream(source);
        FrameSequenceDrawable frameSequenceDrawable = new FrameSequenceDrawable(frameSequence, new FrameSequenceDrawable.BitmapProvider() {
            /**
             * 处理bitmap 回收  利用glide 的bitmappool 节省内存， 防止内存抖动、碎片
             * @param minWidth
             * @param minHeight
             * @return
             */
            @Override
            public Bitmap acquireBitmap(int minWidth, int minHeight) {
                return mBitmapPool.get(minWidth, minHeight, Bitmap.Config.ARGB_8888);
            }

            @Override
            public void releaseBitmap(Bitmap bitmap) {
                mBitmapPool.put(bitmap);
            }
        });
        return new GifResource(frameSequenceDrawable);
    }
}
