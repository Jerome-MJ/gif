# Gif优化

> 此项目中主要将利用Glide加载GIf，以及使用第三方Gif播放控件加载，检测性能问题，选择最优的加载方案

### 1. 文档背景

在项目中突然遇到需求要在recyclerview中加载Gif播放，此前Gif播放一直使用的Glide，但是发现原生Glide直接加载Gif问题颇多，例如设置播放循环次数，播放完成回调，播放卡顿等一系列问题，所以在此做出一个评测，选择最优的Gif加载方案。

我们的页面是这样的要求，一个recyclerview的item中可能存在9张gif。
 ![image](https://github.com/Jerome-MJ/gif/raw/master/images/screen_one.jpg/){:height="1280" width="720"}

还需要实现如果是有多张gif，按顺序循环播放。

### 2. 测试相关说明

机型：ONEPLUS 3T 

内存：6G+128G     安卓8.0系统

在images目录下选用了5张gif图做测试，总文件大小13.3 MB

|                                 | 文件大小 | 像素    |
| ------------------------------- | -------- | ------- |
| ARyFS0.gif                      | 6.61m    | 413X222 |
| 201903291903476763082181140.gif | 1.85m    | 480X267 |
| 201903192012111508026909732.gif | 2.25m    | 350x197 |
| 201903192007151538746977321.gif | 825.09kb | 230x176 |
| 201901231506477629681813175.gif | 60kb     | 240x240 |

### 3. 测试结果

- #### 原生Glide直接加载gif

  ```
  Glide.with(context).asGif().load(gifs[i]).into(gifHolder.iv);
  ```

  Apk文件大小：1,951,413 字节    约2.0M

| 6s   | 打开页面10s | 打开页面30s |
| ---- | ----------- | ----------- |
| 内存 | 84.5MB      | 102MB       |
| CPU  | 20%         | 20%         |

- #### 采用Gif-drwable加载gif

```
GlideApp.with(context).asGifSo().load(gifs[i]).into(gifHolder.iv);
```

Apk文件大小：2.1 MB (2,054,326 字节)

| 6s   | 打开页面10s | 打开页面30s |
| ---- | ----------- | ----------- |
| 内存 | 47.5Mb      | 48.2MB      |
| CPU  | 16%         | 15%         |

- #### 采用FrameSequence加载gif

```
  GlideApp.with(context).asGifFs().load(gifs[i]).into(gifHolder.iv);
```

Apk文件大小：2.7 MB (2,653,354 字节)

|      | 打开页面10s | 打开页面30s |
| ---- | ----------- | ----------- |
| 内存 | 88.5MB      | 88.8MB      |
| CPU  | 20%         | 15%         |

