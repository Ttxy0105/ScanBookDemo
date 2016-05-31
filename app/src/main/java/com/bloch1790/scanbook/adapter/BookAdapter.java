package com.bloch1790.scanbook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bloch1790.scanbook.R;
import com.bloch1790.scanbook.model.BookInfo;
import com.bloch1790.scanbook.util.ImageLoader;
import com.bloch1790.scanbook.util.Utility;

import java.util.List;


public class BookAdapter extends BaseAdapter implements AbsListView.OnScrollListener {
    private final ImageLoader mImageLoader;
    private List<BookInfo> mList;
    private LayoutInflater inflater;
    private int mStart, mEnd;
    public static String[] URLS;
    private boolean mFirstin;

    public BookAdapter(Context context, List<BookInfo> data,ListView listView) {
        mList = data;
        inflater = LayoutInflater.from(context);
        mImageLoader = new ImageLoader(listView);
        URLS = new String[data.size()];
        for (int i = 0; i < data.size(); i++) {
            URLS[i] = data.get(i).getImages().getMedium();
        }
        mFirstin = true;
        //一定要注册对应的事件
        listView.setOnScrollListener(this);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public BookInfo getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.bookinfo_item, null);
            holder.image = (ImageView) convertView.findViewById(R.id.book_cover);
            holder.title = (TextView) convertView.findViewById(R.id.book_title);
            holder.author = (TextView) convertView.findViewById(R.id.book_author);
            holder.rating = (TextView) convertView.findViewById(R.id.book_rate);
            holder.price = (TextView) convertView.findViewById(R.id.book_price);
            holder.publisher = (TextView) convertView.findViewById(R.id.book_publisher);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.title.setText(getItem(position).getTitle());
        holder.author.setText(Utility.parseAuthor(getItem(position).getAuthor()));
        holder.rating.setText(getItem(position).getRating().getAverage());
        holder.price.setText(getItem(position).getPrice());
        holder.publisher.setText(getItem(position).getPublisher());
        String url = getItem(position).getImages().getMedium();
        holder.image.setTag(url);
        mImageLoader.showImageByAsyncTask(holder.image,url);
        return convertView;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState == SCROLL_STATE_IDLE) {
            //加载可见项
            mImageLoader.loadImages(mStart, mEnd);
        } else {
            //停止所有的下载任务
            mImageLoader.cancelAllTasks();
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        mStart = firstVisibleItem;
        mEnd = firstVisibleItem + visibleItemCount;
        //第一次显示的时候调用
        if (mFirstin && visibleItemCount > 0) {
            mImageLoader.loadImages(mStart, mEnd);
            mFirstin = false;
        }
    }

    public class ViewHolder {
        public ImageView image;
        public TextView title;
        public TextView author;
        public TextView rating;
        public TextView price;
        public TextView publisher;
    }



}
