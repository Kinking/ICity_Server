package com.hundsun.jerry.icity.service;

import com.hundsun.jerry.icity.model.Photo;

/**
 * Created by huangzhiyuan on 2017/2/15.
 */
public interface PhotoService {

    //创建一个新照片信息
    Integer addPhoto(Photo photo);

    //更新照片数据
    Integer modify(Photo photo);

    //查询照片数
    Integer count();

}
