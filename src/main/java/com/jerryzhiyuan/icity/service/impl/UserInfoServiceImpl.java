package com.jerryzhiyuan.icity.service.impl;

import com.jerryzhiyuan.icity.mapper.UserInfoMapper;
import com.jerryzhiyuan.icity.model.UserInfo;
import com.jerryzhiyuan.icity.service.UserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by huangzhiyuan on 2017/2/9.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserInfoServiceImpl implements UserInfoService {

    @Resource(name = "userInfoMapper")

    private UserInfoMapper userInfoMapper;

    public String addUserInfo(UserInfo userInfo) {
        //测试传入的数据
        System.out.print("传入的UserName为" + userInfo.getUserName());
        return userInfoMapper.addUserInfo(userInfo);
    }

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

    public boolean judgeUserInfoByUsername(String userName) {
        UserInfo userInfo=userInfoMapper.selectByUsername(userName);

        if (userInfo!=null){
            System.out.println("选出的用户信息不为空");
            return true;
        }
        return false;
    }

    public UserInfo getUserInfoByUsername(String userName){
        UserInfo userInfo=userInfoMapper.selectByUsername(userName);
        return userInfo;
    }
}
