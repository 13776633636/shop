package com.xxxx.portal.interceptor;

import com.xxxx.common.pojo.TAdmin;
import com.xxxx.common.utils.CookieUtil;

import com.xxxx.sso.service.SSOService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("all")
@Component
public class ManagerInterceptor implements HandlerInterceptor {
    @Reference(interfaceClass = SSOService.class)
    private SSOService ssoService;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Value("${user.ticket}")
    private String userTicket;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //      获取用户票据
        String ticket = CookieUtil.getCookieValue(request, "userTicket");
        if (!StringUtils.isEmpty(ticket)) {
//            如果存在，进行验证
            TAdmin admin = ssoService.validdate(ticket);
            request.getSession().setAttribute("user", admin);
            ValueOperations<String, Object> ops = redisTemplate.opsForValue();
            ops.set(userTicket + ":" + ticket, admin, 30, TimeUnit.MINUTES);
            return true;
        }
        response.sendRedirect(request.getContextPath() + "/login");

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
