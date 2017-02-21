package com.hundsun.jerry.icity.service.impl;

import com.hundsun.jerry.icity.mapper.UserInfoMapper;
import com.hundsun.jerry.icity.model.User;
import com.hundsun.jerry.icity.model.UserInfo;
import com.hundsun.jerry.icity.service.UserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by huangzhiyuan on 2017/2/9.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserInfoServiceImpl implements UserInfoService{

    @Resource(name = "userInfoMapper")

    private UserInfoMapper userInfoMapper;

    public Integer updateUserInfoById(UserInfo userInfo) {
        return userInfoMapper.updateUserInfoById(userInfo);
    }

    public boolean judgeUserById(Integer userId) {
        UserInfo userInfo=userInfoMapper.selectByUserId(userId);

        if (userInfo!=null){
            System.out.println("选出的用户信息不为空");
            return true;
        }
        return false;
    }
}
