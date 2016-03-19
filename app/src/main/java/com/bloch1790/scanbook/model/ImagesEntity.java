package com.bloch1790.scanbook.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2016/3/19 0019.
 */
public class ImagesEntity implements Parcelable {
    private String small;
    private String large;
    private String medium;

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.small);
        dest.writeString(this.large);
        dest.writeString(this.medium);
    }

    public ImagesEntity() {
    }

    protected ImagesEntity(Parcel in) {
        this.small = in.readString();
        this.large = in.readString();
        this.medium = in.readString();
    }

    public static final Parcelable.Creator<ImagesEntity> CREATOR = new Parcelable.Creator<ImagesEntity>() {
        @Override
        public ImagesEntity createFromParcel(Parcel source) {
            return new ImagesEntity(source);
        }

        @Override
        public ImagesEntity[] newArray(int size) {
            return new ImagesEntity[size];
        }
    };
}
