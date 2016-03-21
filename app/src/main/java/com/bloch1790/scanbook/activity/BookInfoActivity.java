package com.bloch1790.scanbook.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bloch1790.scanbook.R;
import com.bloch1790.scanbook.model.BookInfo;
import com.bloch1790.scanbook.util.HttpCallbackListener;
import com.bloch1790.scanbook.util.HttpUtil;
import com.bloch1790.scanbook.util.Utility;

import java.io.Serializable;
import java.util.List;

public class BookInfoActivity extends Activity {
    private Intent intent;
    private TextView tv_rate, tv_price, tv_title, tv_author, tv_publisher, tv_date, tv_isbn, tv_summary;
    private TextView tv_page;
    private static TextView tv_content;
    private TextView tv_authorinfo;
    private TextView tv_content_menu;
    private ImageView image;
    private ImageView arrow;
    private BookInfo bookInfo;
    private Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_info);
        initViews();
        setListeners();
        getData();
    }

    private void getData() {
        //获取从MainActivity中传来的Book
        intent = getIntent();
        bookInfo = intent.getParcelableExtra(BookInfo.class.getName());
        setViews();
    }

    private void setViews() {
        for (String tag : Utility.parseTags(bookInfo.getTags())) {
            addTag(tag);
        }
        if (bookInfo.getRating().getAverage().equals("0.0"))
            tv_rate.setText("少于10人评价");
        else
            tv_rate.setText("评分:" + bookInfo.getRating().getAverage() + "分");
        tv_title.setText(bookInfo.getTitle());
        tv_author.setText("作者:" + Utility.parseAuthor(bookInfo.getAuthor()));
        tv_publisher.setText("出版社:" + bookInfo.getPublisher());
        tv_date.setText("出版时间:" + bookInfo.getPubdate());
        tv_isbn.setText("ISBN:" + bookInfo.getIsbn13());
        tv_summary.setText(bookInfo.getSummary());
        tv_page.setText("页数:" + bookInfo.getPages());
        tv_price.setText("定价:" + bookInfo.getPrice());
        tv_content.setText(bookInfo.getCatalog());
        tv_authorinfo.setText(bookInfo.getAuthor_intro());
        new Thread(){
            @Override
            public void run() {
                super.run();
                bitmap = Utility.downLoadBitmap(bookInfo.getImages().getMedium());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        image.setImageBitmap(bitmap);
                    }
                });
            }
        }.start();

    }



    private void setListeners() {
        tv_content_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (BookInfoActivity.tv_content.getVisibility() == View.GONE) {
                    arrow.setImageResource(R.drawable.down);
                    BookInfoActivity.tv_content.setVisibility(View.VISIBLE);
                } else {
                    arrow.setImageResource(R.drawable.right);
                    BookInfoActivity.tv_content.setVisibility(View.GONE);
                }
            }
        });
    }

    private void initViews() {
        tv_title = (TextView) findViewById(R.id.bookview_title);
        tv_author = (TextView) findViewById(R.id.bookview_author);
        tv_publisher = (TextView) findViewById(R.id.bookview_publisher);
        tv_date = (TextView) findViewById(R.id.bookview_publisherdate);
        tv_isbn = (TextView) findViewById(R.id.bookview_isbn);
        tv_summary = (TextView) findViewById(R.id.bookview_summary);
        tv_rate = (TextView) findViewById(R.id.bookview_rate);
        tv_price = (TextView) findViewById(R.id.bookview_price);
        tv_page = (TextView) findViewById(R.id.bookview_pages);
        tv_content = (TextView) findViewById(R.id.bookview_content);
        tv_authorinfo = (TextView) findViewById(R.id.bookview_authorinfo);
        image = (ImageView) findViewById(R.id.bookview_cover);
        arrow = (ImageView) findViewById(R.id.bookview_arrow);
        //目录展开TextView
        tv_content_menu = (TextView) findViewById(R.id.bookview_content_menu);
        tv_content_menu.setClickable(true);
        tv_content_menu.setFocusable(true);
    }

    private void addTag(String tag) {
        LinearLayout ll_tag = (LinearLayout) findViewById(R.id.ll_tag);
        final Button button = new Button(this);
        button.setText(tag);
        button.setTextColor(Color.BLACK);
        button.setTextSize(20);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://api.douban.com/v2/book/search?tag=" + button.getText().toString();
                HttpUtil.sendHttpRequest(url, new HttpCallbackListener() {
                    @Override
                    public void onFinish(String response) {
                        List<BookInfo> list = Utility.parse(response);
                        Intent intent = new Intent(BookInfoActivity.this, BookListActivity.class);
                        intent.putExtra("list", (Serializable) list);
                        startActivity(intent);
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
            }
        });
        ll_tag.addView(button);
    }

}
