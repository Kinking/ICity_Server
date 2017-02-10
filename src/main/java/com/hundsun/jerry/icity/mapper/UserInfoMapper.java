package com.hundsun.jerry.icity.mapper;

import com.hundsun.jerry.icity.model.UserInfo;
import org.springframework.stereotype.Repository;

/**
 * Created by huangzhiyuan on 2017/2/9.
 */
@Repository
public interface UserInfoMapper {
    //更细用户个人信息
    //更新用户数据
    Integer updateUserInfoById(UserInfo userInfo);
}
