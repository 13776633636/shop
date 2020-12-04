package com.xxxx.portal.controller;


import com.github.pagehelper.util.StringUtil;
import com.xxxx.common.pojo.Admin;
import com.xxxx.common.result.BaseResult;
import com.xxxx.portal.service.CookieService;
import com.xxxx.sso.service.SSOService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("user")
public class UserController {

    @Reference(interfaceClass = SSOService.class)
    private SSOService ssoService;

    @Resource
    private CookieService cookieService;
    @RequestMapping("login")
    @ResponseBody
    public BaseResult login(Admin admin, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String ticket=ssoService.login(admin);
        if (!StringUtil.isEmpty(ticket)){
            boolean result=cookieService.setCookies(request,response,ticket);
            //将用户信息存入session中，用于页面返显。
            request.getSession().setAttribute("user",admin);
            return result? BaseResult.success(): BaseResult.error();
        }
        return BaseResult.error();
    }
    @RequestMapping("logout")
    public String logout(HttpServletRequest request,HttpServletResponse response){
        String ticket=cookieService.getCookie(request);
        ssoService.logout(ticket);
        request.getSession().removeAttribute("user");
        cookieService.deleteCookie(request,response);
        return "login";
    }

}
