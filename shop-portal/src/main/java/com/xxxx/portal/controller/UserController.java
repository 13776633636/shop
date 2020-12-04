package com.xxxx.portal.controller;

import com.xxxx.common.pojo.TAdmin;
import com.xxxx.common.result.BaseResult;
import com.xxxx.portal.service.CookieService;
import com.xxxx.portal.service.TAdminService;
import com.xxxx.rpc.service.SendMessageService;
import com.xxxx.sso.service.SSOService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    @Reference(interfaceClass = SendMessageService.class)
    private SendMessageService sendMessageService;

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private CookieService cookieService;
    @Value("${user.ticket}")
    private String userTicket;
    @Autowired
    private TAdminService adminService;


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

    @RequestMapping("register")
    @ResponseBody
    public BaseResult register(TAdmin admin){
        BaseResult baseResult = adminService.saveUser(admin);
        if (baseResult.getCode()==200){
            BaseResult baseResult1=sendMessageService.sendMessage(admin.getEmail());
            if (baseResult1.getCode()==200){
                return BaseResult.success();
            }
        }
        return BaseResult.error();
    }

}
