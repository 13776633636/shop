package com.xxxx.manager.service.impl;

import com.xxxx.common.utils.CookieUtil;
import com.xxxx.manager.service.CookieService;
import org.springframework.stereotype.Service;

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
    public void deleteCookie(HttpServletRequest request, HttpServletResponse response) {
        CookieUtil.deleteCookie(request,response,"userTicket");
    }
}
