package com.creonica.yarara.yararaconfig.model;

/**
 * Created by ak03 on 08/08/2016.
 */
public class User {
    private int mID;
    private String mName;
    private String mPhoneNumber;
    private Boolean mIsAdmin;

    public User(int id, String name, String phoneNumber, Boolean isAdmin) {
        this.mID = id;
        this.mName = name;
        this.mPhoneNumber = phoneNumber;
        this.mIsAdmin = isAdmin;
    }

    public int getID() {
        return mID;
    }

    public void setID(int id) {
        this.mID = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.mPhoneNumber = phoneNumber;
    }

    public Boolean getIsAdmin() {
        return mIsAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.mIsAdmin = isAdmin;
    }
}
