package com.hundsun.jerry.icity.model;

/**
 * Created by huangzhiyuan on 2017/2/16.
 */
public class Moment {
    private Integer mId;
    private Integer uId;
    private String imgUrls;
    private String textContent;
    private String mUpTime;
    private String mDelTime;
    private String mLocation;

    public Moment(Integer mId, Integer uId, String imgUrls, String textContent, String mUpTime, String mDelTime, String mLocation) {
        this.mId = mId;
        this.uId = uId;
        this.imgUrls = imgUrls;
        this.textContent = textContent;
        this.mUpTime = mUpTime;
        this.mDelTime = mDelTime;
        this.mLocation = mLocation;
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

    public String getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String imgUrls) {
        this.imgUrls = imgUrls;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getmUpTime() {
        return mUpTime;
    }

    public void setmUpTime(String mUpTime) {
        this.mUpTime = mUpTime;
    }

    public String getmDelTime() {
        return mDelTime;
    }

    public void setmDelTime(String mDelTime) {
        this.mDelTime = mDelTime;
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }
}
