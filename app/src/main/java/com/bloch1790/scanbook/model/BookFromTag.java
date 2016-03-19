package com.bloch1790.scanbook.model;

import java.util.List;

/**
 * Created by Administrator on 2016/3/19 0019.
 */
public class BookFromTag {

    /**
     * start : 0
     * count : 10
     * total : 30
     * books : ["Book"]
     */

    private int start;
    private int count;
    private int total;
    private List<BookInfo> books;

    public List<BookInfo> getBooks() {
        return books;
    }

    public void setBooks(List<BookInfo> books) {
        this.books = books;
    }



    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
