package com.bloch1790.scanbook.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
        booklist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(BookListActivity.this, BookInfoActivity.class);
                BookInfo info = books.get(position);
                intent.putExtra(BookInfo.class.getName(), info);
                startActivity(intent);
            }
        });
    }
}
