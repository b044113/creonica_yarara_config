package com.creonica.yarara.yararaconfig.model;

import java.util.HashMap;

/**
 * Created by ak03 on 08/08/2016.
 */
public class Alarm {

    private Integer mID;
    private String mDescription;
    private String mPhoneNumber;
    private HashMap<String, Sensor> mSensors;

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    private HashMap<String, User> mUsers;

    public Alarm(int id, String description, String phoneNumber) {
        mID = id;
        mDescription = description;
        mPhoneNumber = phoneNumber;
        mSensors = new HashMap<String, Sensor>();
        mUsers = new HashMap<String, User>();
    }

    public int getID() {
        return mID;
    }

    public void setID(Integer id) {
        mID = id;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public HashMap<String, Sensor>getSensors() {
        return this.mSensors;
    }

    public HashMap<String, User>getUsers() {
        return this.mUsers;
    }
}
