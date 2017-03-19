package com.hundsun.jerry.icity.controller.user;

import com.hundsun.jerry.icity.model.User;
import com.hundsun.jerry.icity.model.UserInfo;
import com.hundsun.jerry.icity.service.UserInfoService;
import com.hundsun.jerry.icity.service.UserService;
import com.hundsun.jerry.icity.utils.json.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.BASE64Decoder;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by huangzhiyuan on 2017/2/6.
 */

@Controller
public class RegisterController {
    @Resource
    private UserService userService;

    private UserInfoService userInfoService;

    private Integer addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        //设置传输字符串的格式
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String fileName = null;  //图片名称
        String urls = null;  //图片所在链接


        //PrintWriter是一种过滤流/处理流，对字节/字符流进行处理
        PrintWriter Pout=response.getWriter();
        String jsonStr=request.getParameter("jsonstring");//安卓端发过来的json的对象名字叫jsonstring

        System.out.println("传入的json字符串为" + jsonStr);

//        //使用Gson将传入的输入流解析到我们后台的User数据类
//        Gson gson = new Gson();
//        User user = gson.fromJson(jsonStr,User.class);


        //使用JsonUtil将传入的输入流解析到我们后台的User数据类
        JsonUtil jsonUtil=new JsonUtil();
        System.out.println(jsonStr);
        List<User> list=jsonUtil.userStringFromJson(jsonStr);
        User user=list.get(0);

//        User user = (User) JsonUtil.getListFromJSON(jsonStr, User[].class);


        //测试相关内容是否写尽了user中
        System.out.print("用户的的url是: " + user.getImg_url() + "\n");
        System.out.println("用户的Email是: " + user.getUserEmail() + "\n");
        System.out.println("用户的Username的是: " + user.getUserName() + "\n");

        //既然能够获得名字和其他，那么头像也一并获取把，用BASE64Decoder解码
        BASE64Decoder decoder = new BASE64Decoder();
        //BASE64Decoder为图片编码
        String base64Str = user.getImg_url();
//      System.out.println("获取到了图片编码数据流"+ base64Str);

        //将编码转换为图片
        byte[] decoderBytes = decoder.decodeBuffer(base64Str);
        for(int j=0;j<decoderBytes.length;++j){
            if(decoderBytes[j]<0){
                decoderBytes[j] += 256;
            }
        }

        //将图片保存到本地并且重新命名
        int len=0;
        //不要以C盘作为直接路径，不然很有可能不成功
        // String path = "/root/morph/img";
        SimpleDateFormat dateFormat = new SimpleDateFormat("'IMG'_yyyyMMdd_HHmmss");
        Date date = new Date(System.currentTimeMillis());
        fileName=dateFormat.format(date) + ".JPEG";

        String path = "/Users/huangzhiyuan/Documents/city_pic"+fileName;
        OutputStream out = new FileOutputStream(path);

//      file = new File(path, fileName);
        urls = "http://xiangsong.online/Morph/img/"+fileName;

//      System.out.println("file:"+file.getName());
        out.write(decoderBytes);
        out.flush();
        out.close();

        //注册用户的同时将userName存入userInfo表中去，方便后面userInfo的相关操作
        UserInfo userInfo = new UserInfo(null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,user.getUserName());
        userInfoService.addUserInfo(userInfo);

        //尽量用print，而不要用printlnf
        return userService.addUser(user);
    }


    @RequestMapping("/RegisterController")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置传输字符串的格式
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        Integer result = addUser(request,response);
        response.setContentType("text/html;charset=	UTF-8");
        response.getWriter().print(result);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("only support post method!");
    }
}
