package top.mj93.gif;

import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideType;
import com.bumptech.glide.request.RequestOptions;

import android.support.rastermill.FrameSequenceDrawable;

/**
 * @author liumengjie
 * @version V1.0
 * @Title: ${file_name}
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/4/3 22:19
 */
@GlideExtension
public class GifExtersion {
    private GifExtersion() {

    }

    @GlideType(FrameSequenceDrawable.class)
    public static RequestBuilder<FrameSequenceDrawable> asGifFs(RequestBuilder<FrameSequenceDrawable> requestBuilder) {
        return requestBuilder.apply(
                RequestOptions.decodeTypeOf(FrameSequenceDrawable.class)
        );
    }
}
