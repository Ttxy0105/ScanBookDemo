package com.bloch1790.scanbook.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.bloch1790.scanbook.model.Book;
import com.bloch1790.scanbook.model.BookFromTag;
import com.bloch1790.scanbook.model.BookInfo;
import com.bloch1790.scanbook.model.TagsEntity;
import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;


public class Utility {
    public Book parseBookInfo(BookInfo bookInfo) {
        Book book = new Book();
        book.setId(bookInfo.getId());
        book.setTitle(bookInfo.getTitle());
        book.setBitmap(downLoadBitmap(bookInfo.getImages().getMedium()));
        book.setAuthor(parseAuthor(bookInfo.getAuthor()));
        book.setPublisher(bookInfo.getPublisher());
        book.setPublishDate(bookInfo.getPubdate());
        book.setIsbn(bookInfo.getIsbn13());
        book.setSummary(bookInfo.getSummary());
        book.setAuthorInfo(bookInfo.getAuthor_intro());
        book.setPage(bookInfo.getPages());
        book.setPrice(bookInfo.getPrice());
        book.setContent(bookInfo.getCatalog());
        book.setRate(bookInfo.getRating().getAverage());
        book.setTags(parseTags(bookInfo.getTags()));
        return book;
    }



    public static BookInfo parseByGson(String jsonData) {
        Gson gson = new Gson();
        BookInfo bookInfo = gson.fromJson(jsonData, BookInfo.class);
        return bookInfo;
    }

    public static List<BookInfo> parse(String jsonData) {
        Gson gson = new Gson();
        BookFromTag result = gson.fromJson(jsonData, BookFromTag.class);
        List<BookInfo> list = result.getBooks();
        return list;
    }

    public static Bitmap downLoadBitmap(String imageUrl) {
        Bitmap bitmap = null;
        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            URL url = new URL(imageUrl);
            URLConnection connection = url.openConnection();
            bufferedInputStream = new BufferedInputStream(connection.getInputStream());
            //将请求返回的字节流编码成Bitmap
            bitmap = BitmapFactory.decodeStream(bufferedInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //关闭IO流
        finally {
            try {
                if (bufferedInputStream != null)
                    bufferedInputStream.close();
                if (inputStream != null)
                    inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bitmap;
    }

    private List<String> parseTags(List<TagsEntity> list_tag) {
        List<String> tags = new ArrayList<>();
        for (TagsEntity tag : list_tag) {
            tags.add(tag.getName());
        }
        return tags;
    }

    private String parseAuthor(List<String> list) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            try {
                str = str.append(list.get(i)).append(" ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str.toString();
    }


}
