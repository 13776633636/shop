package com.xxxx.portal.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xxxx.common.utils.CookieUtil;
import com.xxxx.portal.service.CookieService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class CookieServiceImpl implements CookieService {

    /**
     * 设置cookie
     * @param request
     * @param response
     * @param ticket
     * @return
     */

    @Override
    public boolean setCookies(HttpServletRequest request, HttpServletResponse response, String ticket) {
        try {
            CookieUtil.setCookie(request, response, "userTicket", ticket);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String getCookie(HttpServletRequest request) {
        return CookieUtil.getCookieValue(request,"userTicket");
    }

    @Override
    public boolean deleteCookie(HttpServletRequest request, HttpServletResponse response) {
        CookieUtil.deleteCookie(request,response,"userTicket");
        return true;
    }
}
