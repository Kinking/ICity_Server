package com.jerryzhiyuan.icity.controller.test;

import com.jerryzhiyuan.icity.model.User;
import com.jerryzhiyuan.icity.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by huangzhiyuan on 2017/1/18.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request, Model model){
        log.info("查询所有用户信息");
        List<User> userList = userService.selectAllUser();
        model.addAttribute("userList",userList);
        return "showUser";
    }
}
