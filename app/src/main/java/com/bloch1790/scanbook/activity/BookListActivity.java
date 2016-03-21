package com.bloch1790.scanbook.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.bloch1790.scanbook.R;
import com.bloch1790.scanbook.adapter.BookAdapter;
import com.bloch1790.scanbook.model.BookInfo;

import java.util.ArrayList;

public class BookListActivity extends AppCompatActivity {

    private ListView booklist;
    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        final ArrayList<BookInfo> books =
                (ArrayList<BookInfo>) getIntent().getSerializableExtra("list");
        for (BookInfo book : books) {
            Log.i("TAG", "书名：" + book.getTitle());
        }
        booklist = (ListView) findViewById(R.id.book_list);
        adapter = new BookAdapter(this, books,booklist);
        //adapter.notifyDataSetChanged();
        booklist.setAdapter(adapter);
    }
}
