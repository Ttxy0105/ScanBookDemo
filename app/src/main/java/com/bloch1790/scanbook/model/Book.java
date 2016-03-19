package com.bloch1790.scanbook.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Book implements Parcelable {
    //图书ID
    private String id;
    //图书标题
    private String title;
    //图书作者
    private String author;
    //作者信息
    private String authorInfo;
    //图书出版社
    private String publisher;
    //出版时间
    private String publishDate;
    //图书ISBN码
    private String isbn;
    //图书价格
    private String price;
    //图书页数
    private String page;
    //图书评分
    private String rate;
    //图书标签
    private List<String> tags;
    //图书目录
    private String content;
    //图书摘要
    private String summary;
    //图书图片
    private Bitmap bitmap;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorInfo() {
        return authorInfo;
    }

    public void setAuthorInfo(String authorInfo) {
        this.authorInfo = authorInfo;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.author);
        dest.writeString(this.authorInfo);
        dest.writeString(this.publisher);
        dest.writeString(this.publishDate);
        dest.writeString(this.isbn);
        dest.writeString(this.price);
        dest.writeString(this.page);
        dest.writeString(this.rate);
        dest.writeStringList(this.tags);
        dest.writeString(this.content);
        dest.writeString(this.summary);
        dest.writeParcelable(this.bitmap, flags);
    }

    public Book() {
    }

    protected Book(Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
        this.author = in.readString();
        this.authorInfo = in.readString();
        this.publisher = in.readString();
        this.publishDate = in.readString();
        this.isbn = in.readString();
        this.price = in.readString();
        this.page = in.readString();
        this.rate = in.readString();
        this.tags = in.createStringArrayList();
        this.content = in.readString();
        this.summary = in.readString();
        this.bitmap = in.readParcelable(Bitmap.class.getClassLoader());
    }

    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}
