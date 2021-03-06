package com.xxxx.manager.controller;

import com.xxxx.common.result.BaseResult;
import com.xxxx.common.pojo.TAdmin;
import com.xxxx.common.utils.CookieUtil;
import com.xxxx.manager.service.CookieService;
import com.xxxx.sso.service.SSOService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
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

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private CookieService cookieService;
    @Value("${user.ticket}")
    private String userTicket;


    @RequestMapping("login")
    @ResponseBody
    public BaseResult login(TAdmin admin, HttpServletRequest request, HttpServletResponse response) {
        String ticket = ssoService.login(admin);
        if (!StringUtils.isEmpty(ticket)) {
            boolean result = cookieService.setCookie(request, response, ticket);
            //将用户信息设置到session中
            request.getSession().setAttribute("user", admin);

            return result ? BaseResult.success() : BaseResult.error();
        }
        return BaseResult.error();
    }

    @RequestMapping("logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        String ticket = cookieService.getCookie( request);
        ssoService.logout(ticket);
        ModelAndView modelAndView = new ModelAndView("login");

        request.getSession().removeAttribute("user");
        //删除redis缓存
        Boolean delete = redisTemplate.delete(userTicket + ":" +ticket);
        //删除Cookie
        cookieService.deleteCookie(request,response);


        return modelAndView;
    }

}
