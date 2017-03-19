package com.hundsun.jerry.icity.model;

/**
 * Created by huangzhiyuan on 2017/2/16.
 */
public class Moment {
    private Integer mId;
    private Integer uId;
    private String userNickName;
    private String momentContent;
    private String mUpTime;
    private Double longitude;
    private Double latitude;

    public Moment(Integer mId, Integer uId, String userNickName, String momentContent, String mUpTime, Double longitude, Double latitude) {
        this.mId = mId;
        this.uId = uId;
        this.userNickName = userNickName;
        this.momentContent = momentContent;
        this.mUpTime = mUpTime;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getMomentContent() {
        return momentContent;
    }

    public void setMomentContent(String momentContent) {
        this.momentContent = momentContent;
    }

    public String getmUpTime() {
        return mUpTime;
    }

    public void setmUpTime(String mUpTime) {
        this.mUpTime = mUpTime;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
