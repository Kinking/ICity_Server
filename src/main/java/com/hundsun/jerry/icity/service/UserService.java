package com.hundsun.jerry.icity.service;

import com.hundsun.jerry.icity.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by huangzhiyuan on 2017/1/18.
 */


public interface UserService {
    //登录判断
    public boolean login(String username,String password);

    //创建新用户
    Integer addUser(User user);

    //通过id删除用户
    Integer deleteUserById(@Param("userId") Integer id);

    //更新用户数据
    Integer modify(User user);

    //根据id查询用户数据
    User selectUserById(@Param("userId") Integer userId);

    User selectUserByPhoneOrEmail(@Param("emailOrPhone") String emailOrPhone, @Param("state") Short state);

    //查询所有用户数据
    List<User> selectAllUser();

    //查询用户数
    Integer count();


}
