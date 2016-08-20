package com.creonica.yarara.yararaconfig.model;

import java.util.HashMap;

/**
 * Created by ak03 on 08/08/2016.
 */
public class Alarm {

    private Integer mID;
    private String mDescription;
    private HashMap<String, Sensor> mSensors;
    private HashMap<String, User> mUsers;

    public Alarm(int mID, String mDescription) {
        this.mID = mID;
        this.mDescription = mDescription;
        mSensors = new HashMap<String, Sensor>();
        mUsers = new HashMap<String, User>();
    }

    public int getID() {
        return mID;
    }

    public void setID(Integer id) {
        this.mID = id;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public HashMap<String, Sensor>getSensors() {
        return this.mSensors;
    }

    public HashMap<String, User>getUsers() {
        return this.mUsers;
    }
}
