package com.bloch1790.scanbook.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2016/3/19 0019.
 */
public class TagsEntity implements Parcelable {
    private int count;
    private String name;
    private String title;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.count);
        dest.writeString(this.name);
        dest.writeString(this.title);
    }

    public TagsEntity() {
    }

    protected TagsEntity(Parcel in) {
        this.count = in.readInt();
        this.name = in.readString();
        this.title = in.readString();
    }

    public static final Parcelable.Creator<TagsEntity> CREATOR = new Parcelable.Creator<TagsEntity>() {
        @Override
        public TagsEntity createFromParcel(Parcel source) {
            return new TagsEntity(source);
        }

        @Override
        public TagsEntity[] newArray(int size) {
            return new TagsEntity[size];
        }
    };
}
