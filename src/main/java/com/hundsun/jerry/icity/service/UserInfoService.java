package com.hundsun.jerry.icity.service;

import com.hundsun.jerry.icity.model.UserInfo;

/**
 * Created by huangzhiyuan on 2017/2/9.
 */
public interface UserInfoService {
    //更新各人用户信息
    Integer updateUserInfoById(UserInfo userInfo);
}
