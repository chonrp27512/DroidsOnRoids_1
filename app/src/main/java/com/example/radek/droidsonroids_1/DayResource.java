package com.example.radek.droidsonroids_1;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Radek on 2016-07-25.
 */
public class DayResource implements Parcelable{
    String topic;
    String app;
    String plan;
    String name;

    protected DayResource(Parcel in) {
        topic = in.readString();
        app = in.readString();
        plan = in.readString();
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(topic);
        dest.writeString(app);
        dest.writeString(plan);
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DayResource> CREATOR = new Creator<DayResource>() {
        @Override
        public DayResource createFromParcel(Parcel in) {
            return new DayResource(in);
        }

        @Override
        public DayResource[] newArray(int size) {
            return new DayResource[size];
        }
    };
}
