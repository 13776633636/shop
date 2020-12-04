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

    /**
     * 获取cookie
     * @param request
     * @return
     */
    String getCookie(HttpServletRequest request);

    /**
     * 删除cookie
     * @param request
     * @param response
     * @return
     */
    boolean deleteCookie(HttpServletRequest request, HttpServletResponse response);
}
