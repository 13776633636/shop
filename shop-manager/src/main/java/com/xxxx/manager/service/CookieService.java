package com.xxxx.manager.service;

<<<<<<< Updated upstream
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
=======

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CookieService {
    boolean setCookies(HttpServletRequest request, HttpServletResponse response, String ticket);

    String getCookie(HttpServletRequest request);

    void deleteCookie(HttpServletRequest request, HttpServletResponse response);
>>>>>>> Stashed changes
}
