package com.jerryzhiyuan.icity.controller.user;

import com.jerryzhiyuan.icity.model.Moment;
import com.jerryzhiyuan.icity.service.MomentService;
import com.jerryzhiyuan.icity.utils.json.WriteJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangzhiyuan on 2017/3/23.
 */
@Controller
public class GetMomentInfoController {
    @Resource
    private MomentService momentService;

    private String showMarkers(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{

        String jsonMomentAccept = request.getParameter("jsonMomentRequest");

        String jsonMomentListString = null;

//        if(jsonMomentAccept.equals("jsonMomentRequest")){

            System.out.println("进来了");

            List<Moment> list = new ArrayList<Moment>();

            list = momentService.selectAllMoment();

            WriteJson writeJson = new WriteJson();

            jsonMomentListString = writeJson.getJsonData(list);

            System.out.println(jsonMomentListString);

            //向客户端传回相应字符
            response.setContentType("application/json");

            response.getWriter().write(jsonMomentListString);
//        }

        response.getWriter().close();

        return jsonMomentListString;

    }

    @RequestMapping("/GetMomentInfoController")
    private void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置传输字符串的格式
        response.setContentType("application/json");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String result = showMarkers(request,response);
        response.setContentType("application/json");
        response.getWriter().write(result);

    }

    private void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("only support post method!");
    }
}
