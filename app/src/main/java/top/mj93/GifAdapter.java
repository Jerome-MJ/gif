package top.mj93;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import top.mj93.gif.GlideApp;


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
//        GlideApp.with(context).asGifFs().load(gifs[i]).into(new SimpleTarget<FrameSequenceDrawable>() {
//            @Override
//            public void onResourceReady(@NonNull FrameSequenceDrawable resource, @Nullable Transition<? super FrameSequenceDrawable> transition) {
//                gifHolder.iv.setImageDrawable(resource);
//                resource.start();
//            }
//        });
        GlideApp.with(context).asGifFs().load(gifs[i]).into(gifHolder.iv);
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
