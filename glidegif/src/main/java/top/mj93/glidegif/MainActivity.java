package top.mj93.glidegif;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView gifRv = findViewById(R.id.rv_gif);
        gifRv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        String[] gifs={
                "https://s2.ax1x.com/2019/04/05/ARyFS0.gif",
                "https://img.douyucdn.cn/data/yuba/default/2019/03/29/201903291903476763082181140.gif?i=348030c0c13d6da95d07dcb8bb6d942673",
                "https://img.douyucdn.cn/data/yuba/default/2019/03/19/201903192012111508026909732.gif?i=335072bf3051460e0d1c5d44bb8fff1973",
                "https://img.douyucdn.cn/data/yuba/default/2019/03/19/201903192007151538746977321.gif?i=3230d39b0f85d0f74f907d3ec21c6b1763",
                "https://img.douyucdn.cn/data/yuba/default/2019/01/23/201901231506477629681813175.gif?i=3240f1e5dc8e20fc8fbfcfb28d79f12403"
        };
//        String[] gifs={
//                "https://img.douyucdn.cn/data/yuba/default/2019/03/29/201903291903476763082181140.gif.webp?i=348030c0c13d6da95d07dcb8bb6d942673",
//                "https://img.douyucdn.cn/data/yuba/default/2019/03/19/201903192012111508026909732.gif.webp?i=335072bf3051460e0d1c5d44bb8fff1973",
//                "https://img.douyucdn.cn/data/yuba/default/2019/03/19/201903192007151538746977321.gif.webp?i=3230d39b0f85d0f74f907d3ec21c6b1763",
//                "https://img.douyucdn.cn/data/yuba/default/2019/01/23/201901231506477629681813175.gif.webp?i=3240f1e5dc8e20fc8fbfcfb28d79f12403",
//        };
        gifRv.setAdapter(new GifAdapter(this,gifs));
    }
}
