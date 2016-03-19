package com.bloch1790.scanbook.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2016/3/19 0019.
 */
public class SeriesEntity implements Parcelable {
    private String id;
    private String title;

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.title);
    }

    public SeriesEntity() {
    }

    protected SeriesEntity(Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
    }

    public static final Parcelable.Creator<SeriesEntity> CREATOR = new Parcelable.Creator<SeriesEntity>() {
        @Override
        public SeriesEntity createFromParcel(Parcel source) {
            return new SeriesEntity(source);
        }

        @Override
        public SeriesEntity[] newArray(int size) {
            return new SeriesEntity[size];
        }
    };
}
