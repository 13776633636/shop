package com.xxxx.sso.service;

import com.xxxx.common.pojo.TAdmin;

/**
 * 单点登录服务
 */
public interface SSOService {
    String login(TAdmin admin);
    /**
     * 验证票据
     */
    TAdmin validdate(String ticket);
    /**
     * 退出
     */
    void logout(String ticket);
}
