package com.hundsun.jerry.icity.controller.user;

import com.hundsun.jerry.icity.model.User;
import com.hundsun.jerry.icity.service.UserService;
import com.hundsun.jerry.icity.utils.json.JsonUtil;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by huangzhiyuan on 2017/1/21.
 */
@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Resource
    private UserService userService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //设置传输字符串的格式
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //PrintWriter是一种过滤流/处理流，对字节/字符流进行处理
        PrintWriter out=response.getWriter();
        String jsondata=request.getParameter("jsonstring");//安卓端发过来的json的对象名字叫jsonstring

        JsonUtil jsonUtil=new JsonUtil();
        System.out.println(jsondata);
        List<User> list=jsonUtil.StringFromJson(jsondata);

        User user=list.get(0);
        System.out.println(user.getId());

        userService.addUser(user);
//        boolean b=userDaoImpl.register(user);
//        if (b)
//        {
//            out.write("t");
//        }
//        else {
//            out.write("f");
//        }
//        out.flush();
//        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
