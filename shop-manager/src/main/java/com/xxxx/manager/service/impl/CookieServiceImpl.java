package com.xxxx.manager.service.impl;

import com.xxxx.common.utils.CookieUtil;
import com.xxxx.manager.service.CookieService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie 服务实现类
 */
@Service
public class CookieServiceImpl implements CookieService {
    /**
     * 设置Cookie
     *
     * @param request
     * @param response
     * @param ticket
     * @return
     */
    @Override
    public boolean setCookie(HttpServletRequest request, HttpServletResponse response, String ticket) {

        try{
            CookieUtil.setCookie(request,response,"userTicket",ticket);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }
}
