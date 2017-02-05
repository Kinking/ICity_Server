package com.hundsun.jerry.icity.controller.user;

import com.google.gson.Gson;
import com.hundsun.jerry.icity.model.User;
import com.hundsun.jerry.icity.service.UserService;
import sun.misc.BASE64Decoder;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by huangzhiyuan on 2017/1/21.
 */
@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Resource
    private UserService userService;

    private Integer addUser(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String fileName = null;  //图片名称
        String urls = null;  //图片所在链接
        User user = null;

        try {
            //读取request输入流，获得传入数据的大小，然后声明一个与其大小相同的流将其装入
            int contentLength = request.getContentLength();
            byte buffer[] = new byte[contentLength];

            for (int i = 0; i < contentLength; ) {
                int readlen = request.getInputStream().read(buffer, i, contentLength - i);
                if (readlen == -1) {
                    break;
                }


                i += readlen;
                String jsonStr = new String(buffer, "utf-8");
                //测试是否能够读出来
                System.out.print(jsonStr);

                Gson gson = new Gson();
                //使用gson将传入的输入流解析到我们后台的User数据类
                user = gson.fromJson(jsonStr, User.class);


                //测试相关内容是否写尽了user中
//                System.out.print(user.getImg_url());
//                System.out.println(user.getUserEmail());
//                System.out.println(user.getUserName());

                //既然能够获得名字和其他，那么头像也一并获取把，用BASE64Decoder解码
                BASE64Decoder decoder = new BASE64Decoder();
                //BASE64Decoder为图片编码
                String base64Str = user.getImg_url();
//                System.out.println("获取到了图片编码数据流"+ base64Str);

                //将编码转换为图片
                byte[] decoderBytes = decoder.decodeBuffer(base64Str);
                for(int j=0;j<decoderBytes.length;++j){
                    if(decoderBytes[i]<0){
                        decoderBytes[i] += 256;
                    }
                }

                //将图片保存到本地并且重新命名
                int len=0;
                //不要以C盘作为直接路径，不然很有可能不成功
                // String path = "/root/morph/img";
                SimpleDateFormat dateFormat = new SimpleDateFormat("'IMG'_yyyyMMdd_HHmmss");
                Date date = new Date(System.currentTimeMillis());
                fileName=dateFormat.format(date) + ".JPEG";

                String path = "/Users/huangzhiyuan/Documents/"+fileName;
                OutputStream out = new FileOutputStream(path);
//
//
//
//
//            file = new File(path, fileName);
                urls = "http://xiangsong.online/Morph/img/"+fileName;
//
//
//
//            System.out.println("file:"+file.getName());
                out.write(decoderBytes);
                out.flush();
                out.close();



            }
        }catch (Exception e){
            e.printStackTrace();
        }

        //尽量用print，而不要用println
        return userService.addUser(user);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer result = addUser(request,response);
        response.setContentType("text/html;charset=	UTF-8");
        response.getWriter().print(result);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("only support post method!");
    }
}
