package com.xxxx.manager.interceptor;

import com.xxxx.common.pojo.Admin;
import com.xxxx.common.utils.CookieUtil;
import com.xxxx.common.utils.JsonUtil;
import com.xxxx.sso.service.SSOService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;
@Component
public class ManagerLoginInterceptor implements HandlerInterceptor {


    @Reference(interfaceClass = SSOService.class)
    private SSOService ssoService;
    @Resource
    private RedisTemplate<String, String> redisTemplate;
    @Value("${user.ticket}")
    private String userTicket;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ticket=CookieUtil.getCookieValue(request,"userTicket");
        if (!StringUtils.isEmpty(ticket)) {
            //票据存在，进行验证
            Admin admin=ssoService.validate(ticket);
            //将用户信息存入session中
            request.getSession().setAttribute("user",admin);
            //重新设置失效时间
              ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
                valueOperations.set(userTicket+":"+ticket, JsonUtil.object2JsonStr(admin),30,
                        TimeUnit.MINUTES);
                return true;
        }
        //重定向到登录页面
        response.sendRedirect(request.getContextPath()+"/login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
