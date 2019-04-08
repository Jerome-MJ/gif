package top.mj93.gif_drawable.gif;

import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideType;
import com.bumptech.glide.request.RequestOptions;

import pl.droidsonroids.gif.GifDrawable;

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

    @GlideType(GifDrawable.class)
    public static RequestBuilder<GifDrawable> asGifSo(RequestBuilder<GifDrawable> requestBuilder) {
        return requestBuilder.apply(
                RequestOptions.decodeTypeOf(GifDrawable.class)
        );
    }
}
