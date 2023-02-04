package com.example.simplerecyclerview;

import android.os.Parcel;
import android.os.Parcelable;

public class User2 implements Parcelable {
    private String name, phoneNumber;
    private Sex sex;

    public User2(String name, String phoneNumber, Sex sex) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    protected User2(Parcel in) {
        this.name = in.readString();
        this.phoneNumber = in.readString();
        this.sex = Sex.values()[in.readInt()];
    }

    public static final Creator<User2> CREATOR = new Creator<User2>() {
        @Override
        public User2 createFromParcel(Parcel in) {
            return new User2(in);
        }

        @Override
        public User2[] newArray(int size) {
            return new User2[size];
        }
    };

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Sex getSex() {
        return this.sex;
    }
    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.phoneNumber);
        dest.writeInt(this.sex.ordinal());
    }
}
