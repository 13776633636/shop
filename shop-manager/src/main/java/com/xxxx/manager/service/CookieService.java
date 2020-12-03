package com.xxxx.manager.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie服务
 */
public interface CookieService {
    /**
     * 设置Cookie
     * @param request
     * @param response
     * @param ticket
     * @return
     */
    boolean setCookie(HttpServletRequest request, HttpServletResponse response,String ticket);
}
