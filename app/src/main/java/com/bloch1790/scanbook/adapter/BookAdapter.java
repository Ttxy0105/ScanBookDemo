package com.bloch1790.scanbook.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bloch1790.scanbook.R;
import com.bloch1790.scanbook.model.Book;

import java.util.List;

/**
 * Created by Administrator on 2016/3/19 0019.
 */
public class BookAdapter extends BaseAdapter{
    private List<Book> list;
    private LayoutInflater inflater;

    public BookAdapter(Context context,List<Book> list) {
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Book getItem(int position) {
        return list.get(position);
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
        holder.author.setText(getItem(position).getAuthor());
        holder.rating.setText(getItem(position).getRate());
        holder.price.setText(getItem(position).getPrice());
        holder.publisher.setText(getItem(position).getPublisher());
        holder.image.setImageBitmap(getItem(position).getBitmap());
        return convertView;
    }


    public class ViewHolder{
        public ImageView image;
        public TextView title;
        public TextView author;
        public TextView rating;
        public TextView price;
        public TextView publisher;
    }
}
