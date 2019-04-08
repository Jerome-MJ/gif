package top.mj93.gif_drawable;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.io.File;
import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;


public class GifAdapter extends RecyclerView.Adapter<GifAdapter.GifHolder> {

    private Context context;
    private String[] gifs;

    public GifAdapter(Context context, String[] gifs) {
        this.gifs = gifs;
        this.context = context;
    }

    @NonNull
    @Override
    public GifHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.gif_item,
                viewGroup, false);
        return new GifHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final GifHolder gifHolder, final int i) {
        //as(FrameSequenceDrawable.class)
//        GlideApp.with(context).asGifSo().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).load(gifs[i]).into(gifHolder.iv);
        Glide.with(context).asFile().load(gifs[i]).into(new SimpleTarget<File>() {
            @Override
            public void onResourceReady(@NonNull File resource, @Nullable Transition<? super File> transition) {
                try {
                    gifHolder.iv.setImageDrawable(new GifDrawable(resource));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        gifHolder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),BigImageViewActivity.class);
                intent.putExtra("url",gifs[i]);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return gifs.length;
    }

    static class GifHolder extends RecyclerView.ViewHolder {
        ImageView iv;

        public GifHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
        }
    }
}
