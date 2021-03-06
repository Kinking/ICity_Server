package com.jerryzhiyuan.icity.mapper;

import com.jerryzhiyuan.icity.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by huangzhiyuan on 2017/1/17.
 */
@Repository
public interface UserMapper {

    //创建新用户
    Integer addUser(User user);

    //用户登录判断登录
    User selectByUsername(@Param("username")String username);

    //通过id删除用户
    Integer deleteUserById(@Param("userId") Integer id);

    //更新用户数据
    Integer updateUserById(User user);

    //根据id查询用户数据
    User selectUserById(@Param("userId") Integer userId);

    //根据userName查询用户id
    Integer selectIdByUsername(@Param("userName") String userName);

    User selectUserByPhoneOrEmail(@Param("emailOrPhone") String emailOrPhone, @Param("state") Short state);

    //查询所有用户数据
    List<User> selectAllUser();

    //查询用户数
    Integer count();

}
