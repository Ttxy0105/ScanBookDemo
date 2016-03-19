package com.bloch1790.scanbook.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2016/3/19 0019.
 */
public class RatingEntity implements Parcelable {
    //rating : {"max":10,"numRaters":935,"average":"9.1","min":0}
    private int max;
    private int numRaters;
    private String average;
    private int min;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getNumRaters() {
        return numRaters;
    }

    public void setNumRaters(int numRaters) {
        this.numRaters = numRaters;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.max);
        dest.writeInt(this.numRaters);
        dest.writeString(this.average);
        dest.writeInt(this.min);
    }

    public RatingEntity() {
    }

    protected RatingEntity(Parcel in) {
        this.max = in.readInt();
        this.numRaters = in.readInt();
        this.average = in.readString();
        this.min = in.readInt();
    }

    public static final Parcelable.Creator<RatingEntity> CREATOR = new Parcelable.Creator<RatingEntity>() {
        @Override
        public RatingEntity createFromParcel(Parcel source) {
            return new RatingEntity(source);
        }

        @Override
        public RatingEntity[] newArray(int size) {
            return new RatingEntity[size];
        }
    };
}
