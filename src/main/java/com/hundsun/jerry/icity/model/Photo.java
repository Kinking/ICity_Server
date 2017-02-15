package com.hundsun.jerry.icity.model;

/**
 * Created by huangzhiyuan on 2017/2/15.
 */
public class Photo {
    private Integer pId;
    private Integer uId;
    private String photoName;
    private String photoUrl;
    private String uploadTime;
    private String photoRemark;

    public Photo(Integer pId, Integer uId, String photoName, String photoUrl, String uploadTime, String photoRemark) {
        this.pId = pId;
        this.uId = uId;
        this.photoName = photoName;
        this.photoUrl = photoUrl;
        this.uploadTime = uploadTime;
        this.photoRemark = photoRemark;
    }


    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getPhotoRemark() {
        return photoRemark;
    }

    public void setPhotoRemark(String photoRemark) {
        this.photoRemark = photoRemark;
    }
}
