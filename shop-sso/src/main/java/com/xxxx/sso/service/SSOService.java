package com.xxxx.sso.service;

import com.xxxx.common.pojo.Admin;

public interface SSOService {
    /**
     * 登录认证方法返回票据ticket
     * @param admin
     * @return
     */
    String login(Admin admin);

    /**
     *验证票据ticket返回用户信息
     */
    Admin validate(String ticket);

    void logout(String ticket);
}
