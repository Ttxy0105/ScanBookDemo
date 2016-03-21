package com.bloch1790.scanbook.util;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.LruCache;
import android.widget.ImageView;
import android.widget.ListView;

import com.bloch1790.scanbook.R;
import com.bloch1790.scanbook.adapter.BookAdapter;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/3/21 0021.
 */
public class ImageLoader {


    //创建Cache
    private LruCache<String, Bitmap> mCache;
    private ListView mListView;
    private Set<NewsAsyncTask> mTask;


    public ImageLoader(ListView listView) {
        mListView = listView;
        mTask = new HashSet<>();
        //获取最大可用内存
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int cacheSize = maxMemory / 4;
        mCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                //在每次存入缓存的时候调用
                return value.getByteCount();
            }
        };
    }

    //增加到缓存
    public void addBitmapToCache(String url, Bitmap bitmap) {
        if (getBitmapFromCache(url) == null) {
            mCache.put(url, bitmap);
        }
    }

    //从缓存中获取数据
    public Bitmap getBitmapFromCache(String url) {
        return mCache.get(url);
    }

    public Bitmap getBitmapFromURL(String urlString) {
        return Utility.downLoadBitmap(urlString);
    }

    public void showImageByAsyncTask(ImageView imageView, String url) {
        //从缓存中取出对应的图片
        Bitmap bitmap = getBitmapFromCache(url);
        //如果缓存中没有，那么必须去下载
        if (bitmap == null) {
            imageView.setImageResource(R.mipmap.ic_launcher);
        } else {
            imageView.setImageBitmap(bitmap);
        }
    }

    //用来加载从start到end的所有图片
    public void loadImages(int start, int end) {
        for (int i = start; i < end; i++) {
            String url = BookAdapter.URLS[i];
            //从缓存中取出对应的图片
            Bitmap bitmap = getBitmapFromCache(url);
            //如果缓存中没有，那么必须去下载
            if (bitmap == null) {
                NewsAsyncTask task = new NewsAsyncTask(url);
                task.execute(url);
                mTask.add(task);
            } else {
                ImageView imageView = (ImageView) mListView.findViewWithTag(url);
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    public void cancelAllTasks() {
        if (mTask != null) {
            for (NewsAsyncTask task : mTask) {
                task.cancel(false);
            }
        }
    }

    private class NewsAsyncTask extends AsyncTask<String, Void, Bitmap> {

        //private ImageView mImageView;
        private String mUrl;


        public NewsAsyncTask( String url) {
            //mImageView = imageView;
            mUrl = url;
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            String url = params[0];
            //从网络获取图片
            Bitmap bitmap = getBitmapFromURL(url);
            if (bitmap != null) {
                //将不在缓存的图片加入缓存
                addBitmapToCache(url, bitmap);
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            ImageView imageView = (ImageView) mListView.findViewWithTag(mUrl);
            if (imageView != null && bitmap != null) {
                imageView.setImageBitmap(bitmap);
            }
            mTask.remove(this);
        }
    }
}
