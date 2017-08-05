package com.jerryzhiyuan.icity.service.impl;

import com.jerryzhiyuan.icity.mapper.PhotoMapper;
import com.jerryzhiyuan.icity.model.Photo;
import com.jerryzhiyuan.icity.service.PhotoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by huangzhiyuan on 2017/2/15.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class PhotoServiceImpl implements PhotoService {

    @Resource(name = "photoMapper")

    private PhotoMapper photoMapper;

    public Integer addPhoto(Photo photo) {
        //测试传入的数据
        System.out.print("传入的UserName为" + photo.getPhotoName());
        return photoMapper.addPhoto(photo);
    }

    public Integer modify(Photo photo) {
        return photoMapper.updatePhotoById(photo);
    }

    public Integer count() {
        return photoMapper.count();
    }
}
