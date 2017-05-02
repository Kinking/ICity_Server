package com.hundsun.jerry.icity.controller.user;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by huangzhiyuan on 2017/4/30.
 */

@Controller
public class PicController {

    @RequestMapping("/PicController")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置传输字符串的格式
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        /***将字符串转以Base64编码格式转为图片，传过来的字符串变量名为img***/
        String fileName = null;

        //定义存储图片变量地址
        String imagePath = "";
        String imgBase64 = request.getParameter("img");
        System.out.println("进来的图片字符串为" + imgBase64);
        try{
            //将base64 转 字节数组
            Base64 base = new Base64();
            byte[] decode = base.decode(imgBase64);

            //图片保存到本地后重命名
            SimpleDateFormat dateFormat = new SimpleDateFormat("'IMG'_yyyyMMdd_HHmmss");
            Date date = new Date(System.currentTimeMillis());
            fileName = dateFormat.format(date)+".JPEG";

            //图片输出路径,目前路径设置有问题
            imagePath = "/Users/huangzhiyuan/Pictures/pictestPath/" + fileName;
            //定义图片输入流
            InputStream fin = new ByteArrayInputStream(decode);
            //定义图片输出流
            OutputStream fout = new FileOutputStream(imagePath);
            //写文件
            byte[] b = new byte[1024];
            int length = 0;
            while ((length=fin.read(b))>0){
                fout.write(b,0,length);
            }

            //关闭数据流
            fin.close();
            fout.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
