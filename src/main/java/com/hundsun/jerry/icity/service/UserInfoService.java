package com.hundsun.jerry.icity.service;

import com.hundsun.jerry.icity.model.UserInfo;

/**
 * Created by huangzhiyuan on 2017/2/9.
 */
public interface UserInfoService {
    //第一次注册时根据UserName建表
    String addUserInfo(UserInfo userInfo);

    //更新各人用户信息
    Integer updateUserInfoById(UserInfo userInfo);

    //根据id判断用户信息是否为空
    boolean judgeUserById(Integer userId);

    //根据userName判断UserInfo是否为空
    boolean judgeUserInfoByUsername(String userName);

    //根据userName获取UserInfo的内容
    public UserInfo getUserInfoByUsername(String userName);

}
