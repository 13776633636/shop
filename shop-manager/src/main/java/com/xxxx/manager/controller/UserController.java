package com.xxxx.manager.controller;

import com.xxxx.common.result.BaseResult;
import com.xxxx.common.pojo.TAdmin;
import com.xxxx.sso.service.SSOService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户controller
 */
@RequestMapping("user")
@Controller
public class UserController {

    @Reference(interfaceClass = SSOService.class)
    private SSOService ssoService;

    @RequestMapping("login")
    @ResponseBody
    public BaseResult login(TAdmin admin , HttpServletRequest request, HttpServletResponse response){
        ssoService.login(admin);
        return BaseResult.success();
    }

}
