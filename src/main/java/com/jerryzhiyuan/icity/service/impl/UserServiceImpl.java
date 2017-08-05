package com.jerryzhiyuan.icity.service.impl;

import com.jerryzhiyuan.icity.mapper.UserMapper;
import com.jerryzhiyuan.icity.model.User;
import com.jerryzhiyuan.icity.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by huangzhiyuan on 2017/1/18.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Resource(name = "userMapper")

    private UserMapper userMapper;

    public boolean login(String username, String password) {
        System.out.print("传入UserServiceImpl的login方法的参数为"+username+"和"+password+"\n");

        User user = userMapper.selectByUsername(username);//此句有问题
/***********此处参数为空************/
        System.out.print("进入if之前查询出来的UserId:" + user.getId()+"\n");

        if(user!=null){

            System.out.print("进入if之后查询出来的账号:" + user.getUserName() + "密码:" + user.getUserPwd()+"\n");

            if(user.getUserName().equals(username)&&user.getUserPwd().equals(password)) return true;
        }
        return false;
    }

    public Integer addUser(User user) {
        //测试传入的数据
        System.out.print("传入的UserName为" + user.getUserName());
        return userMapper.addUser(user);
    }

    public Integer deleteUserById(@Param("userId") Integer id) {
        return userMapper.deleteUserById(id);
    }

    public Integer modify(User user) {
        return userMapper.updateUserById(user);
    }

    public User selectUserById(@Param("userId") Integer userId) {
        return userMapper.selectUserById(userId);
    }

    public User selectUserByPhoneOrEmail(@Param("emailOrPhone") String emailOrPhone, @Param("state") Short state) {
        return userMapper.selectUserByPhoneOrEmail(emailOrPhone,state);
    }

    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

    public Integer count() {
        return userMapper.count();
    }

    public Integer getUserId(String userName) {
        return userMapper.selectIdByUsername(userName);
    }


}
