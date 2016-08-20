package com.creonica.yarara.yararaconfig.model;

/**
 * Created by La Popa on 19/08/2016.
 */
public class Sensor {
    public enum SensorStatus {ENABLED, DISABLED};

    private Integer mID;
    private String mDescription;
    private SensorStatus mStatus;

    public Sensor(Integer id) {
        this.mID = id;
        mDescription = "";
        mStatus = SensorStatus.DISABLED;
    }

    public Sensor(Integer id, String description, SensorStatus status) {
        this.mID = id;
        mDescription = description;
        mStatus = status;
    }

    public Integer getmID() {
        return mID;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public SensorStatus getStatus() {
        return mStatus;
    }

    public void setStatus(SensorStatus status) {
        this.mStatus = status;
    }
}
