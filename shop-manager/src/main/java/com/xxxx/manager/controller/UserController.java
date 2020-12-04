package com.xxxx.manager.controller;


import com.github.pagehelper.util.StringUtil;
import com.xxxx.common.enums.BaseResultEnum;
import com.xxxx.common.pojo.Admin;
import com.xxxx.common.result.BaseResult;
import com.xxxx.manager.service.CookieService;
import com.xxxx.sso.service.SSOService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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
    public BaseResult login(Admin admin, HttpServletRequest request, HttpServletResponse response,String verify)  {
        //获取验证码
        String capText= (String) request.getSession().getAttribute("pictureVerfuKey");
        BaseResult baseResult=new BaseResult();
        //判断验证码是否为空或者一致
        if (StringUtils.isEmpty(verify.trim())||!verify.trim().equals(capText)){
            baseResult.setCode(BaseResultEnum.PASS_ERROR_03.getCode());
            baseResult.setMessage(BaseResultEnum.PASS_ERROR_03.getMessage());
            return baseResult;
        }
        String ticket=ssoService.login(admin);
        if (!StringUtil.isEmpty(ticket)){
            boolean result=cookieService.setCookies(request,response,ticket);
            //将用户信息存入session中，用于页面返显。
            request.getSession().setAttribute("user",admin);
            return result? BaseResult.success(): BaseResult.error();
        }
        baseResult.setCode(BaseResultEnum.PASS_ERROR_04.getCode());
        baseResult.setMessage(BaseResultEnum.PASS_ERROR_04.getMessage());
        return baseResult;
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
