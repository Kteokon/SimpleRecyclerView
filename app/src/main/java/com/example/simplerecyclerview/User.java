package com.example.simplerecyclerview;

import java.io.Serializable;

public class User implements Serializable {
    private String name, phoneNumber;
    private Sex sex;

    public User(String name, String phoneNumber, Sex sex) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

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
}
