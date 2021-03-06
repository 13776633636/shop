package com.xxxx.portal.controller;

import com.xxxx.common.result.BaseResult;
import com.xxxx.portal.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CaptchaController {
    @Autowired
    private CaptchaService captchaService;

    //注册时生成验证码
    @PostMapping("/getCaptcha")
    @ResponseBody
    public BaseResult getCaptcha(String ticket, String randStr) {

        return captchaService.captcha(ticket,randStr);
    }
}
