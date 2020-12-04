package com.xxxx.portal.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CookieService {
    boolean setCookies(HttpServletRequest request, HttpServletResponse response, String ticket);

    String getCookie(HttpServletRequest request);

    boolean deleteCookie(HttpServletRequest request,HttpServletResponse response);
}
