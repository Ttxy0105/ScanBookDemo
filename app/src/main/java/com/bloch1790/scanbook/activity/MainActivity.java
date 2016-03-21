package com.bloch1790.scanbook.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bloch1790.scanbook.R;
import com.bloch1790.scanbook.model.BookInfo;
import com.bloch1790.scanbook.util.HttpCallbackListener;
import com.bloch1790.scanbook.util.HttpUtil;
import com.bloch1790.scanbook.util.Utility;

public class MainActivity extends Activity {

    private Button button;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScanActivity.class);
                startActivityForResult(intent, 0);
            }
        });
        //接收来自下载线程的消息
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                BookInfo bookInfo = (BookInfo) msg.obj;
                if (bookInfo == null) {
                    Toast.makeText(MainActivity.this, "没有找到这本书", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, BookInfoActivity.class);
                    //通过Intent 传递 Object，需要让该实体类实现Parceable接口
                    intent.putExtra(BookInfo.class.getName(), bookInfo);
                    startActivity(intent);
                }
            }
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 0:
                if (resultCode == RESULT_OK) {
                    final String address = "https://api.douban.com/v2/book/isbn/" + data.getStringExtra("isbn");
                    HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {
                        @Override
                        public void onFinish(String response) {
                            Message message = Message.obtain();
                            BookInfo bookInfo = Utility.parseByGson(response.toString());
                            message.obj = bookInfo;
                            handler.sendMessage(message);
                        }

                        @Override
                        public void onError(Exception e) {

                        }

                    });
                }
                break;
        }
    }

}

