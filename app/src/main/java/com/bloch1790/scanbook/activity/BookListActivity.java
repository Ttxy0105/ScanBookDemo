package com.bloch1790.scanbook.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.bloch1790.scanbook.R;
import com.bloch1790.scanbook.adapter.BookAdapter;
import com.bloch1790.scanbook.model.Book;
import com.bloch1790.scanbook.model.BookInfo;
import com.bloch1790.scanbook.util.Utility;

import java.util.ArrayList;
import java.util.List;

public class BookListActivity extends AppCompatActivity {

    private ListView booklist;
    private BookAdapter adapter;
    List<Book> book_list = new ArrayList<Book>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        final ArrayList<BookInfo> books =
                (ArrayList<BookInfo>) getIntent().getSerializableExtra("list");
        new Thread(new Runnable() {
            @Override
            public void run() {
                //List<Book> book_list = new ArrayList<Book>();
                for (BookInfo bookInfo : books) {
                    Book book = new Book();
                    book = new Utility().parseBookInfo(bookInfo);
                    book_list.add(book);
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        }).start();
        for (Book book : book_list) {
            Log.i("TAG", "书名：" + book.getTitle());
        }
        booklist = (ListView) findViewById(R.id.book_list);
        adapter = new BookAdapter(this, book_list);
        //adapter.notifyDataSetChanged();
        booklist.setAdapter(adapter);
    }
}
