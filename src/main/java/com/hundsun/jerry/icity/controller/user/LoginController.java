package com.hundsun.jerry.icity.controller.user;

import com.hundsun.jerry.icity.service.UserInfoService;
import com.hundsun.jerry.icity.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by huangzhiyuan on 2017/2/5.
 */

@Controller
public class LoginController {
    @Resource
    private UserService userService;
    private UserInfoService userInfoService;

    @RequestMapping("/LoginController")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();

        System.out.println("进来了");

        String username=request.getParameter("username");
        String password=request.getParameter("password");

        System.out.println("获得的账号和密码是"+username+"和"+password);

        boolean b=userService.login(username,password);

        System.out.print("b的值为"+ b );

        if (b)
        {
            out.write("登录成功");
        }
        else
        {
            out.write("登录失败");
        }
        out.flush();
        out.close();

        System.out.println("执行完了判断");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
