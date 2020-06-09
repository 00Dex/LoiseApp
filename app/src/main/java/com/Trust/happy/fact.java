package com.Trust.happy;

import android.os.Parcel;
import android.os.Parcelable;

public class fact implements Parcelable
{
    String likes;


    protected fact(Parcel in) {
    }

    public static final Creator<fact> CREATOR = new Creator<fact>() {
        @Override
        public fact createFromParcel(Parcel in) {
            return new fact(in);
        }

        @Override
        public fact[] newArray(int size) {
            return new fact[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
