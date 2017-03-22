package com.hundsun.jerry.icity.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.hundsun.jerry.icity.model.Moment;
import com.hundsun.jerry.icity.service.MomentService;
import com.hundsun.jerry.icity.utils.json.JsonUtil;
import com.hundsun.jerry.icity.utils.json.JsonUtilMoment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by huangzhiyuan on 2017/3/19.
 */

@Controller
public class MomentController {
    @Resource
    private MomentService momentService;


    private Integer addMoment(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        //设置传输字符串的格式
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //PrintWriter是一种过滤流/处理流，对字节/字符流进行处理
        PrintWriter Pout=response.getWriter();
        String jsonMomentStr=request.getParameter("jsonstring");//安卓端发过来的json的对象名字叫jsonmomentstring

        System.out.println("传入的json字符串为" + jsonMomentStr);

        //使用JsonUtil将传入的输入流解析到我们后台的User数据类
        JsonUtil jsonUtil=new JsonUtil();
        List<Moment> list=jsonUtil.momentStringFromJson(jsonMomentStr);
        Moment moment=list.get(0);
        System.out.println("验证是否打包进了Json1："+moment.getMomentContent());
        return momentService.addMoment(moment);

    }

    @RequestMapping("/MomentController")
    private void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置传输字符串的格式
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        Integer result = addMoment(request,response);
        response.setContentType("text/html;charset=	UTF-8");
        response.getWriter().print(result);

    }

    private void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("only support post method!");
    }


}
