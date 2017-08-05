package com.jerryzhiyuan.icity.mapper;

import com.jerryzhiyuan.icity.model.Photo;
import org.springframework.stereotype.Repository;

/**
 * Created by huangzhiyuan on 2017/2/15.
 */
@Repository
public interface PhotoMapper {

    //创建一个新的照片记录
    Integer addPhoto(Photo photo);

    //更新照片数据
    Integer updatePhotoById(Photo photo);

    //查询照片数
    Integer count();
}
