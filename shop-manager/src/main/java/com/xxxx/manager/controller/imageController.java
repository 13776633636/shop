package com.xxxx.manager.controller;


import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequestMapping("image")
public class imageController {

    @Resource
    private DefaultKaptcha defaultKaptcha;

    @RequestMapping("getKaptchaImage")
    public void getKaptchaImage(HttpServletRequest request , HttpServletResponse response){
        //定义respose输出类型为image/jpeg类型
        response.setDateHeader("Expires",0);
        response.setHeader("Cache-Control","no-store,must-revalidate");
        response.addHeader("Cache-Control","post-check=0,pre-check=0");
        response.setHeader("Pragma","no-cache");
        response.setContentType("image/jpeg");
        //生成图形验证码
        String text=defaultKaptcha.createText();
        System.out.println("验证码内容"+text);
        //将验证按放入session中
        request.getSession().setAttribute("pictureVerifyKey",text);
        BufferedImage image=defaultKaptcha.createImage(text);
        ServletOutputStream outputStream=null;
        try {
            outputStream=response.getOutputStream();
            ImageIO.write(image,"jpg",outputStream);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null==outputStream){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
