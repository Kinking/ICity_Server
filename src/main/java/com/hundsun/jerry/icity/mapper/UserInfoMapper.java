package com.hundsun.jerry.icity.mapper;

import com.hundsun.jerry.icity.model.UserInfo;
import org.springframework.stereotype.Repository;

/**
 * Created by huangzhiyuan on 2017/2/9.
 */
@Repository
public interface UserInfoMapper {

    //更细用户个人信息
    Integer updateUserInfoById(UserInfo userInfo);

    //根据用户Id获取用户信息
    UserInfo selectByUserId(Integer userId);

    //根据用户Username获取用户信息
    UserInfo selectByUsername(String userName);

    //仅仅插入Username
    String addUserInfo(UserInfo userName);
}
