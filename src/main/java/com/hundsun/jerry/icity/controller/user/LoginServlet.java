package com.hundsun.jerry.icity.controller.user;

import com.hundsun.jerry.icity.service.UserService;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by huangzhiyuan on 2017/1/21.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    @Resource
    private UserService userService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        System.out.println("进来了");
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        boolean b=userService.login(username,password);
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
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
